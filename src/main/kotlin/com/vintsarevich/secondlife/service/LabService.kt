package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.ConditionType
import com.vintsarevich.secondlife.model.Lab
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.repository.LabRepository
import org.springframework.stereotype.Service

@Service
class LabService(private val labRepository: LabRepository) {

    fun calculateLabs(order: Order): List<Lab> {
        val testRecommendationConditions =
            order.survey?.testRecommendation?.conditions?.filter { it.type == ConditionType.TEST_RECOMMENDATION_CONDITION }!!

        val labs = labRepository.findAll()
        return labs.filter { it.conditions.containsAll(testRecommendationConditions) }
    }

    fun getLabById(labId: Long): Lab {
        return labRepository.getOne(labId)
    }
}