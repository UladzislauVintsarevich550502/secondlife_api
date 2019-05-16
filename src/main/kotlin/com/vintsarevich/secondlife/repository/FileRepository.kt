package com.vintsarevich.secondlife.repository

import com.vintsarevich.secondlife.model.File
import com.vintsarevich.secondlife.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : JpaRepository<File, Long> {
    fun findByOrder(order: Order): File?
}