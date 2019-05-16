package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.DiseaseStage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiseaseStageRepository : JpaRepository<DiseaseStage, Long>