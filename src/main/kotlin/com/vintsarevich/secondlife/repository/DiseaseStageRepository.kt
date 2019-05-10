package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.DiseaseStage
import org.springframework.data.jpa.repository.JpaRepository

interface DiseaseStageRepository : JpaRepository<DiseaseStage, Long>