package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.PatientInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientInfoRepository : JpaRepository<PatientInfo, Long>