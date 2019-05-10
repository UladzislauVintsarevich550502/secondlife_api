package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
final class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun getAllOrders() = orderService.getAllOrders()

    @GetMapping("/new")
    fun startNewOrder(@RequestParam name: String, @RequestParam doctor: String) =
        orderService.startNewOrder(name, doctor)

    @PutMapping("/survey/disease")
    fun addDiseaseToOrder(@RequestParam orderId: Long, @RequestParam diseaseId: Long) =
        orderService.addDiseaseToOrder(orderId, diseaseId)

    @PutMapping("/survey/disease_stage")
    fun addDiseaseStageToOrder(@RequestParam orderId: Long, @RequestParam diseaseStageId: Long) =
        orderService.addDiseaseStageToOrder(orderId, diseaseStageId)
}