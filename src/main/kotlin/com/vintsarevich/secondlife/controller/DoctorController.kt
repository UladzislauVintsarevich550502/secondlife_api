package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.dto.DoctorDto
import com.vintsarevich.secondlife.service.DoctorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/doctor")
final class DoctorController(
    private val doctorService: DoctorService
) {
    @PostMapping
    fun checkDoctor(@RequestBody doctorDto: DoctorDto) = doctorService.checkDoctor(doctorDto)
}