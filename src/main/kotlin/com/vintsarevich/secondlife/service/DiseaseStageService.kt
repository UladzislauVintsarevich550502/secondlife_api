package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.DiseaseStage
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.repository.DiseaseStageRepository
import org.springframework.stereotype.Service

@Service
class DiseaseStageService(private val diseaseStageRepository: DiseaseStageRepository) {

    fun calculateDiseaseStages(order: Order): List<DiseaseStage> {
        val diseaseConditions = order.survey?.disease?.conditions!!
        val diseaseStages = diseaseStageRepository.findAll()
        return diseaseStages.filter { it.conditions.containsAll(diseaseConditions) }
    }

    fun getDiseaseStageById(diseaseStageId: Long): DiseaseStage {
        return diseaseStageRepository.getOne(diseaseStageId)
    }
}