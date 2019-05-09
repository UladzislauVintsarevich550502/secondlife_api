package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.dto.DoctorDto
import com.vintsarevich.secondlife.model.Doctor
import com.vintsarevich.secondlife.repository.DoctorRepository
import org.springframework.stereotype.Service

@Service
class DoctorService(private val doctorRepository: DoctorRepository) {

    fun checkDoctor(doctorDto: DoctorDto): Int {
        val doctor = doctorRepository.findByUsername(doctorDto.username) ?: return 1
        return if (doctor.password == doctorDto.password) 2 else 3
    }

    fun findDoctorByUsername(username: String): Doctor? {
        return doctorRepository.findByUsername(username)
    }
}