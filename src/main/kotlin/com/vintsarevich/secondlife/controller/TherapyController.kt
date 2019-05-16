package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.model.Therapy
import com.vintsarevich.secondlife.service.OrderService
import com.vintsarevich.secondlife.service.TherapyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/therapy")
final class TherapyController(
    private val therapyService: TherapyService,
    private val orderService: OrderService
) {
    @GetMapping
    fun calculateTherapies(@RequestParam orderId: Long): List<Therapy> {
        val order = orderService.getOrderById(orderId)
        return therapyService.calculateTherapies(order)
    }
}