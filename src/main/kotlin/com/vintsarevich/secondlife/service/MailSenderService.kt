package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Order
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import javax.activation.DataHandler
import javax.activation.FileDataSource
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

@Service
class MailSenderService {

    fun generateAndSendEmail(data: ByteArray, order: Order) {
        sendEmail(order.survey?.lab?.email!!, getFileFormByteArray(data))
    }

    @Throws(MessagingException::class, IOException::class)
    private fun sendEmail(email: String, file: File) {
        val properties = Properties()
        properties.load(MailSenderService::class.java.classLoader.getResourceAsStream("my.properties"))
        val session = Session.getDefaultInstance(properties, null)
        val message = MimeMessage(session)
        message.addRecipient(Message.RecipientType.TO, InternetAddress(email))
        message.subject = "Patient Information"

        val info = MimeBodyPart()
        info.setText("Please check patient information and make response. Thank you!")

        val attachment = MimeBodyPart()
        attachment.dataHandler = DataHandler(FileDataSource(file))
        attachment.fileName = file.name

        val multipart = MimeMultipart()
        multipart.addBodyPart(info)
        multipart.addBodyPart(attachment)

        message.setContent(multipart)

        val transport = session.getTransport("smtp")
        transport.connect(GMAIL_HOST, GMAIL_USERNAME, GMAIL_PASSWORD)
        transport.sendMessage(message, message.allRecipients)
        transport.close()
    }

    private fun getFileFormByteArray(data: ByteArray): File {
        val file = File("patient.pdf")
        if(file.exists()) {
            file.delete()
        }
        file.createNewFile()
        val document = FileOutputStream(file)
        document.write(data)
        document.close()

        return file
    }

    companion object {
        private const val GMAIL_HOST = "smtp.gmail.com"
        private const val GMAIL_PASSWORD = "P8MW68NACmrRGN7"
        private const val GMAIL_USERNAME = "vintsarevich.education@gmail.com"
    }
}
