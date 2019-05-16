package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.TestRecommendation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRecommendationRepository : JpaRepository<TestRecommendation, Long>