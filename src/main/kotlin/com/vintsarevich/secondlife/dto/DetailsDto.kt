package com.vintsarevich.secondlife.dto

data class DetailsDto(
    var orderName: String,
    var doctorName: String,
    var labName: String,
    var patientName: String,
    var disease: String,
    var testRecommendation: String,
    var therapy: String
)