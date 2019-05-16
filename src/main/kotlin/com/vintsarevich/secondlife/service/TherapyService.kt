package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Condition
import com.vintsarevich.secondlife.model.ConditionType
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.model.Therapy
import com.vintsarevich.secondlife.repository.TherapyRepository
import org.springframework.stereotype.Service

@Service
class TherapyService(private val therapyRepository: TherapyRepository) {

    fun calculateTherapies(order: Order): List<Therapy> {
        val diseaseConditions = order.survey?.disease?.conditions!!
        val diseaseStageConditions =
            order.survey?.diseaseStage?.conditions!!.filter { it.type == ConditionType.DISEASE_STAGE_CONDITION }

        val therapies = therapyRepository.findAll()
        return therapies.filter(fun(therapy: Therapy): Boolean {
            val therapyConditions =
                therapy.conditions.filter { it.type != ConditionType.THERAPY_CONDITION }
            return checkDiseaseConditions(therapyConditions, diseaseConditions)
                    && checkDiseaseStageConditions(therapyConditions, diseaseStageConditions)
        })
    }

    private fun checkDiseaseStageConditions(
        conditions: List<Condition>,
        diseaseStageConditions: List<Condition>
    ): Boolean {
        return when {
            conditions.none { it.type == ConditionType.DISEASE_STAGE_CONDITION } -> true
            conditions.all { it.negative } -> conditions.none { diseaseStageConditions.contains(it) }
            else -> conditions.any { diseaseStageConditions.contains(it) }
        }
    }

    private fun checkDiseaseConditions(conditions: List<Condition>, diseaseConditions: List<Condition>): Boolean {
        return if (conditions.none { it.type == ConditionType.DISEASE_CONDITION }) true
        else conditions.containsAll(diseaseConditions)
    }

    fun getTherapyById(therapyId: Long): Therapy {
        return therapyRepository.getOne(therapyId)
    }
}