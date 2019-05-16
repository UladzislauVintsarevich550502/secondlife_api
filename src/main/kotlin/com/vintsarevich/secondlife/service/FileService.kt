package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.dto.ReportXmlDto
import com.vintsarevich.secondlife.model.File
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.repository.FileRepository
import org.apache.fop.apps.FopFactory
import org.apache.fop.apps.MimeConstants
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.StringReader
import java.io.StringWriter
import java.text.SimpleDateFormat
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.transform.Source
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamSource

@Service
class FileService(private val fileRepository: FileRepository, private val mailSenderService: MailSenderService) {

    fun createFile(order: Order): Boolean {
        var file = fileRepository.findByOrder(order)
        val document = generatePdf(order)
        if (file == null) {
            file = File(order.name, order, document)
        } else {
            file.data = document
        }
        fileRepository.save(file)
        mailSenderService.generateAndSendEmail(file.data, order)
        return true
    }

    private fun generatePdf(order: Order): ByteArray {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val reportXmlDto = ReportXmlDto(
            order.doctor?.username!!,
            order.doctor?.email!!,
            order.survey?.lab?.name!!,
            order.survey?.lab?.name!!,
            formatter.format(order.patientInfo?.dateOfBirthday!!),
            order.patientInfo?.gender!!,
            order.patientInfo?.firstName!!,
            order.patientInfo?.secondName!!,
            order.patientInfo?.address!!,
            order.survey?.disease?.name!!,
            order.survey?.testRecommendation?.name!!,
            order.survey?.therapy?.name!!
        )
        return buildPdf(reportXmlDto)
    }

    @Throws(IOException::class)
    private fun buildPdf(reportXmlDto: ReportXmlDto): ByteArray {
        ByteArrayOutputStream().use { out ->
            val xmlSource = getXmlForm(reportXmlDto)
            val xsltFormStream = javaClass.classLoader.getResourceAsStream(TEMPLATE_PATH)
            val fopFactory = FopFactory.newInstance(java.io.File("./temp").toURI())
            val fop = fopFactory.newFop(MimeConstants.MIME_PDF, fopFactory.newFOUserAgent(), out)
            val transformer = TransformerFactory.newInstance().newTransformer(StreamSource(xsltFormStream))
            val res = SAXResult(fop.defaultHandler)
            transformer.transform(xmlSource, res)
            return out.toByteArray()
        }
    }

    @Throws(JAXBException::class)
    private fun getXmlForm(reportXmlDto: ReportXmlDto): Source {
        val jaxbContext = JAXBContext.newInstance(reportXmlDto.javaClass)
        val jaxbMarshaller = jaxbContext.createMarshaller()
        val sw = StringWriter()
        jaxbMarshaller.marshal(reportXmlDto, sw)
        val sr = StringReader(sw.toString())
        return StreamSource(sr)
    }

    companion object {
        var TEMPLATE_PATH = "templates/labReport.xml"
    }

}