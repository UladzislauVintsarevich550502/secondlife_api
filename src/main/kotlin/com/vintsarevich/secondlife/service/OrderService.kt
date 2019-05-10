package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.dto.OrderDto
import com.vintsarevich.secondlife.mapper.Mapper
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.model.OrderStatus
import com.vintsarevich.secondlife.model.Survey
import com.vintsarevich.secondlife.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val doctorService: DoctorService,
    private val diseaseService: DiseaseService,
    private val diseaseStageService: DiseaseStageService,
    private val mapper: Mapper
) {

    fun getAllOrders(): List<OrderDto> {
        return mapper.map(orderRepository.findAll(), OrderDto::class.java)
    }

    fun startNewOrder(name: String, doctor: String): Long {
        var order = orderRepository.findByName(name)
        if (order == null) {
            order = orderRepository.save(
                Order(
                    name,
                    null,
                    doctorService.findDoctorByUsername(doctor),
                    OrderStatus.ORDER_START,
                    Survey("$name survey", null, null)
                )
            )
        }
        return if (order.status == OrderStatus.ORDER_START) order.id!! else -1
    }

    fun addDiseaseToOrder(orderId: Long, diseaseId: Long) {
        val order = orderRepository.getOne(orderId)
        val disease = diseaseService.getDiseaseById(diseaseId)

        order.survey!!.disease = disease
    }

    fun addDiseaseStageToOrder(orderId: Long, diseaseStageId: Long) {
        val order = orderRepository.getOne(orderId)
        val diseaseStage = diseaseStageService.getDiseaseStageById(diseaseStageId)

        order.survey!!.diseaseStage = diseaseStage
    }

    fun getOrderById(orderId: Long): Order {
        return orderRepository.getOne(orderId)
    }
}