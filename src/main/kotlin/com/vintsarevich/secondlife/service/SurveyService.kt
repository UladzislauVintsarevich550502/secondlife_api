package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.Survey
import com.vintsarevich.secondlife.repository.SurveyRepository
import org.springframework.stereotype.Service

@Service
class SurveyService(private val surveyRepository: SurveyRepository) {

    fun createNewSurvey(newSurvey: Survey): Survey {
        return surveyRepository.save(newSurvey)
    }
}