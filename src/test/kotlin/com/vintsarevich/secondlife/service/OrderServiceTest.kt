package com.vintsarevich.secondlife.service

import com.nhaarman.mockito_kotlin.whenever
import com.vintsarevich.secondlife.AbstractUnitTest
import com.vintsarevich.secondlife.model.Disease
import com.vintsarevich.secondlife.repository.DiseaseRepository
import org.junit.Assert
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

class OrderServiceTest : AbstractUnitTest() {

    @Mock
    private lateinit var diseaseRepository: DiseaseRepository

    @InjectMocks
    private lateinit var diseaseService: DiseaseService

    @Test
    fun testGetAllDisease() {
        val allDiseases = listOf(
            Disease("Melanoma", emptyList()),
            Disease("Gist", emptyList())
        )
        whenever(diseaseRepository.findAll()).thenReturn(allDiseases)

        val diseases = diseaseService.getAllDisease()

        Assert.assertEquals("Melanoma", diseases?.get(0)?.name)
        Assert.assertEquals("Gist", diseases?.get(1)?.name)
    }

    @Test
    fun testGetDiseaseById() {
        val diseaseId = 1L
        val disease = Disease("Melanoma", emptyList())
        whenever(diseaseRepository.getOne(diseaseId)).thenReturn(disease)

        val result = diseaseService.getDiseaseById(diseaseId)

        Assert.assertEquals(disease, result)
    }
}