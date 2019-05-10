package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Condition
import com.vintsarevich.secondlife.model.DiseaseStage
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.repository.DiseaseStageRepository
import org.springframework.stereotype.Service

@Service
class DiseaseStageService(private val diseaseStageRepository: DiseaseStageRepository) {

    fun calculateDiseaseStages(order: Order): List<DiseaseStage> {
        val diseasePositiveConditions =
            order.survey?.disease?.conditions?.filter { condition -> !condition.negative } as List<Condition>
        val diseaseNegativeConditions =
            order.survey?.disease?.conditions?.filter { condition -> condition.negative } as List<Condition>
        val diseaseStages = diseaseStageRepository.findAll()
        return diseaseStages.filter(fun(diseaseStage: DiseaseStage): Boolean {
            val diseaseStageConditions = diseaseStage.conditions
            return diseaseStageConditions.containsAll(diseasePositiveConditions) && diseaseStageConditions.none {
                diseaseNegativeConditions.contains(it)
            }
        })
    }

    fun getDiseaseStageById(diseaseStageId: Long): DiseaseStage {
        return diseaseStageRepository.getOne(diseaseStageId)
    }
}