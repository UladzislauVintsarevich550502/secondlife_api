package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.model.PatientInfo
import com.vintsarevich.secondlife.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
final class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun getAllOrders() = orderService.getAllOrders()

    @GetMapping("/{id}")
    fun getDetails(@PathVariable("id") id: Long) = orderService.getDetails(id)

    @GetMapping("/new")
    fun startNewOrder(@RequestParam name: String, @RequestParam doctor: String) =
        orderService.startNewOrder(name, doctor)

    @PutMapping("/survey/disease")
    fun addDiseaseToOrder(@RequestParam orderId: Long, @RequestParam diseaseId: Long) =
        orderService.addDiseaseToOrder(orderId, diseaseId)

    @PutMapping("/survey/disease_stage")
    fun addDiseaseStageToOrder(@RequestParam orderId: Long, @RequestParam diseaseStageId: Long) =
        orderService.addDiseaseStageToOrder(orderId, diseaseStageId)

    @PutMapping("/survey/therapy")
    fun addTherapyToOrder(@RequestParam orderId: Long, @RequestParam therapyId: Long) =
        orderService.addTherapyToOrder(orderId, therapyId)

    @PutMapping("/survey/test_recommendation")
    fun addTestRecommendationToOrder(@RequestParam orderId: Long, @RequestParam testRecommendationId: Long) =
        orderService.addTestRecommendationToOrder(orderId, testRecommendationId)

    @PutMapping("/survey/lab")
    fun addLabToOrder(@RequestParam orderId: Long, @RequestParam labId: Long) =
        orderService.addLabToOrder(orderId, labId)

    @PostMapping("/submit_order")
    fun submitOrder(@RequestParam orderId: Long, @RequestBody patientInfo: PatientInfo) = orderService.submitOrder(orderId, patientInfo)
}