package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Survey
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyRepository : JpaRepository<Survey, Long>