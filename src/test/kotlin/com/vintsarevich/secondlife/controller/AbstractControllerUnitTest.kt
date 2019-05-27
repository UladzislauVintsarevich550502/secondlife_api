package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.AbstractUnitTest
import org.junit.Before
import org.mockito.InjectMocks
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

abstract class AbstractControllerUnitTest : AbstractUnitTest() {

    protected lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        val field = javaClass.declaredFields.find { it.isAnnotationPresent(InjectMocks::class.java) }!!
        field.isAccessible = true
        mockMvc = MockMvcBuilders.standaloneSetup(field.get(this)).build()
    }
}
