package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Condition
import com.vintsarevich.secondlife.model.ConditionType
import com.vintsarevich.secondlife.model.Order
import com.vintsarevich.secondlife.model.TestRecommendation
import com.vintsarevich.secondlife.repository.TestRecommendationRepository
import org.springframework.stereotype.Service

@Service
class TestRecommendationService(private val testRecommendationRepository: TestRecommendationRepository) {

    fun calculateTestRecommendations(order: Order): List<TestRecommendation> {
        val diseaseConditions = order.survey?.disease?.conditions!!
        val therapyConditions =
            order.survey?.therapy?.conditions!!.filter { it.type == ConditionType.THERAPY_CONDITION }

        val therapies = testRecommendationRepository.findAll()
        return therapies.filter(fun(testRecommendation: TestRecommendation): Boolean {
            val testRecommendationConditions = testRecommendation.conditions
            return checkDiseaseConditions(testRecommendationConditions, diseaseConditions) &&
                    checkTherapyConditions(testRecommendationConditions, therapyConditions)
        })
    }

    private fun checkTherapyConditions(conditions: List<Condition>, therapyConditions: List<Condition>): Boolean {
        return if (conditions.none { it.type == ConditionType.THERAPY_CONDITION }) true
        else conditions.containsAll(therapyConditions)
    }

    private fun checkDiseaseConditions(conditions: List<Condition>, diseaseConditions: List<Condition>): Boolean {
        return if (conditions.none { it.type == ConditionType.DISEASE_CONDITION }) true
        else conditions.containsAll(diseaseConditions)
    }

    fun getTestRecommendationById(testRecommendationId: Long): TestRecommendation {
        return testRecommendationRepository.getOne(testRecommendationId)
    }
}