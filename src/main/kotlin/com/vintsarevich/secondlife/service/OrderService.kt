package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.dto.DetailsDto
import com.vintsarevich.secondlife.dto.OrderDto
import com.vintsarevich.secondlife.mapper.Mapper
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.model.OrderStatus
import com.vintsarevich.secondlife.model.PatientInfo
import com.vintsarevich.secondlife.model.Survey
import com.vintsarevich.secondlife.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val doctorService: DoctorService,
    private val diseaseService: DiseaseService,
    private val diseaseStageService: DiseaseStageService,
    private val therapyService: TherapyService,
    private val testRecommendationService: TestRecommendationService,
    private val labService: LabService,
    private val patientInfoService: PatientInfoService,
    private val surveyService: SurveyService,
    private val fileService: FileService,
    private val mapper: Mapper
) {

    fun getAllOrders(): List<OrderDto> {
        return mapper.map(orderRepository.findAll(), OrderDto::class.java).sortedBy { Long.MAX_VALUE - it.id }
    }

    fun startNewOrder(name: String, doctor: String): Long {
        var order = orderRepository.findByName(name)
        if (order == null) {
            val survey = surveyService.createNewSurvey(Survey("$name survey", null, null, null, null, null))
            order = orderRepository.save(
                Order(name, doctorService.findDoctorByUsername(doctor), OrderStatus.ORDER_START, survey, null)
            )
        }
        return if (order.status == OrderStatus.ORDER_START) order.id!! else -1
    }

    fun addDiseaseToOrder(orderId: Long, diseaseId: Long) {
        val order = orderRepository.getOne(orderId)
        val disease = diseaseService.getDiseaseById(diseaseId)

        order.survey!!.disease = disease

        orderRepository.save(order)
    }

    fun addDiseaseStageToOrder(orderId: Long, diseaseStageId: Long) {
        val order = orderRepository.getOne(orderId)
        val diseaseStage = diseaseStageService.getDiseaseStageById(diseaseStageId)

        order.survey!!.diseaseStage = diseaseStage

        orderRepository.save(order)
    }

    fun addTherapyToOrder(orderId: Long, therapyId: Long) {
        val order = orderRepository.getOne(orderId)
        val therapy = therapyService.getTherapyById(therapyId)

        order.survey!!.therapy = therapy

        orderRepository.save(order)
    }

    fun addTestRecommendationToOrder(orderId: Long, testRecommendationId: Long) {
        val order = orderRepository.getOne(orderId)
        val testRecommendation = testRecommendationService.getTestRecommendationById(testRecommendationId)

        order.survey!!.testRecommendation = testRecommendation

        orderRepository.save(order)
    }

    fun addLabToOrder(orderId: Long, labId: Long) {
        val order = orderRepository.getOne(orderId)
        val lab = labService.getLabById(labId)

        order.survey!!.lab = lab

        orderRepository.save(order)
    }

    fun getOrderById(orderId: Long): Order {
        return orderRepository.getOne(orderId)
    }

    fun submitOrder(orderId: Long, patientInfo: PatientInfo): Boolean {
        val order = orderRepository.getOne(orderId)
        order.patientInfo = patientInfoService.savePatientInfo(patientInfo)
        order.status = OrderStatus.ORDER_COMPLETE
        if (fileService.createFile(order)) {
            order.status = OrderStatus.ORDER_SUBMIT_TO_LAB
            orderRepository.save(order)
            return true
        }
        orderRepository.save(order)
        return false
    }

    fun getDetails(id: Long): DetailsDto {
        val order = orderRepository.getOne(id)
        return DetailsDto(
            order.name,
            order.doctor?.username!!,
            order.survey?.lab?.name!!,
            order.patientInfo?.firstName!!,
            order.survey?.disease?.name!!,
            order.survey?.testRecommendation?.name!!,
            order.survey?.therapy?.name!!
        )
    }
}