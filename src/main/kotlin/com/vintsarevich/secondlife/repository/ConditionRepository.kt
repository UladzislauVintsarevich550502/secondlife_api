package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.Condition
import org.springframework.data.jpa.repository.JpaRepository

interface ConditionRepository : JpaRepository<Condition, Long>