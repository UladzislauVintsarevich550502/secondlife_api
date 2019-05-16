package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Therapy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TherapyRepository : JpaRepository<Therapy, Long>