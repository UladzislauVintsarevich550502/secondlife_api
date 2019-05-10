package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Disease
import org.springframework.data.jpa.repository.JpaRepository

interface DiseaseRepository : JpaRepository<Disease, Long>