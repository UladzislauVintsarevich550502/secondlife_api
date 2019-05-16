package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Lab
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LabRepository : JpaRepository<Lab, Long>