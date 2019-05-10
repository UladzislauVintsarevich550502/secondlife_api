package com.vintsarevich.secondlife.service

import com.vintsarevich.secondlife.repository.ConditionRepository
import org.springframework.stereotype.Service

@Service
class ConditionService(private val conditionRepository: ConditionRepository)