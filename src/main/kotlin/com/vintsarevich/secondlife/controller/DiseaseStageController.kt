package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.model.DiseaseStage
import com.vintsarevich.secondlife.model.OrderStatus
import com.vintsarevich.secondlife.service.DiseaseService
import com.vintsarevich.secondlife.service.DiseaseStageService
import com.vintsarevich.secondlife.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/disease_stage")
final class DiseaseStageController(
    private val diseaseStageService: DiseaseStageService,
    private val orderService: OrderService
) {
    @GetMapping
    fun calculateDiseaseStages(@RequestParam orderId: Long) : List<DiseaseStage> {
        val order = orderService.getOrderById(orderId)
        return diseaseStageService.calculateDiseaseStages(order)
    }
}