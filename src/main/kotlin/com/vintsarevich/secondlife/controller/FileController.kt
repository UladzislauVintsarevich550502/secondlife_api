package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.service.FileService
import com.vintsarevich.secondlife.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/file")
final class FileController(
    private val fileService: FileService,
    private val orderService: OrderService
) {
    @GetMapping
    fun generateReport(@RequestParam orderId: Long): Boolean {
        val order = orderService.getOrderById(orderId)
        return fileService.createFile(order)
    }
}