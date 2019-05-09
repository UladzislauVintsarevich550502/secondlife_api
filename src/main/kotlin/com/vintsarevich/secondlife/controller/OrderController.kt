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

    @PostMapping
    fun startNewOrder(@RequestParam name: String, @RequestParam doctor: String) = orderService.startNewOrder(name, doctor)
}