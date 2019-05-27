package com.vintsarevich.secondlife.controller

import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.vintsarevich.secondlife.dto.DetailsDto
import com.vintsarevich.secondlife.dto.OrderDto
import com.vintsarevich.secondlife.model.OrderStatus
import com.vintsarevich.secondlife.service.OrderService
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

class OrderControllerTest : AbstractControllerUnitTest() {
    @Mock
    private lateinit var orderService: OrderService

    @InjectMocks
    private lateinit var controller: OrderController

    @Test
    fun testGetActiveCohOrder() {
        val allOrders = listOf(
            OrderDto(1L, "MRN1", OrderStatus.ORDER_START.toString()),
            OrderDto(2L, "MRN2", OrderStatus.ORDER_ARCHIVED.toString())
        )

        whenever(orderService.getAllOrders()).thenReturn(allOrders)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/order")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))

        verify(orderService).getAllOrders()
    }

    @Test
    fun testGetDetails() {
        val orderId = 1L
        val detailsDto = DetailsDto(
            "order", "doctor", "lab", "patient",
            "disease", "testRecommendation", "therapy"
        )

        whenever(orderService.getDetails(orderId)).thenReturn(detailsDto)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/order/{id}", orderId)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.orderName").value("order"))

        verify(orderService).getDetails(orderId)
    }
}
