package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Survey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SurveyRepository : JpaRepository<Survey, Long>