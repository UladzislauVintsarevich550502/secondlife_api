package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.model.PatientInfo
import com.vintsarevich.secondlife.repository.PatientInfoRepository
import org.springframework.stereotype.Service

@Service
class PatientInfoService(private val patientInfoRepository: PatientInfoRepository) {

    fun savePatientInfo(patientInfo: PatientInfo): PatientInfo = patientInfoRepository.save(patientInfo)
}