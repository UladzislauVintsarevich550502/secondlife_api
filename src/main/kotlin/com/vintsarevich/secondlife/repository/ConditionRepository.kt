package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Condition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConditionRepository : JpaRepository<Condition, Long>