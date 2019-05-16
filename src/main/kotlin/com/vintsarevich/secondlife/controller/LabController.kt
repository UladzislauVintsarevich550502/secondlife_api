package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.model.Lab
import com.vintsarevich.secondlife.service.LabService
import com.vintsarevich.secondlife.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lab")
final class LabController(
    private val labService: LabService,
    private val orderService: OrderService
) {
    @GetMapping
    fun calculateLabs(@RequestParam orderId: Long): List<Lab> {
        val order = orderService.getOrderById(orderId)
        return labService.calculateLabs(order)
    }
}