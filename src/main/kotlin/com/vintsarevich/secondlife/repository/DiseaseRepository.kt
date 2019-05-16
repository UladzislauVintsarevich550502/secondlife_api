package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Disease
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiseaseRepository : JpaRepository<Disease, Long>