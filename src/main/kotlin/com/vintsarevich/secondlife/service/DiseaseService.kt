package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Disease
import com.vintsarevich.secondlife.repository.DiseaseRepository
import org.springframework.stereotype.Service

@Service
class DiseaseService(private val diseaseRepository: DiseaseRepository) {

    fun getAllDisease(): List<Disease>? {
        return diseaseRepository.findAll()
    }

    fun getDiseaseById(diseaseId: Long): Disease {
        return diseaseRepository.getOne(diseaseId)
    }
}