package com.vintsarevich.secondlife.controller

import com.vintsarevich.secondlife.service.DiseaseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/disease")
final class DiseaseController(
    private val diseaseService: DiseaseService
) {
    @GetMapping
    fun getAllDisease() = diseaseService.getAllDisease()
}