package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.model.TestRecommendation
import com.vintsarevich.secondlife.service.OrderService
import com.vintsarevich.secondlife.service.TestRecommendationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test_recommendation")
final class TestRecommendationController(
    private val testRecommendationService: TestRecommendationService,
    private val orderService: OrderService
) {
    @GetMapping
    fun calculateTestRecommendations(@RequestParam orderId: Long): List<TestRecommendation> {
        val order = orderService.getOrderById(orderId)
        return testRecommendationService.calculateTestRecommendations(order)
    }
}