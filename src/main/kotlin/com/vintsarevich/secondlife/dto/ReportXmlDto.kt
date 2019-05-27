package com.vintsarevich.secondlife.dto

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "reportXmlDto")
class ReportXmlDto {
    var doctorName: String? = null
    var doctorEmail: String? = null
    var labName: String? = null
    var labEmail: String? = null
    var birth: String? = null
    var gender: String? = null
    var firstName: String? = null
    var secondName: String? = null
    var address: String? = null
    var disease: String? = null
    var testRecommendation: String? = null
    var therapy: String? = null

    constructor(
        doctorName: String,
        doctorEmail: String,
        labName: String,
        labEmail: String,
        birth: String,
        gender: String,
        firstName: String,
        secondName: String,
        address: String,
        disease: String,
        testRecommendation: String,
        therapy: String
    ) {
        this.doctorName = doctorName
        this.doctorEmail = doctorEmail
        this.labName = labName
        this.labEmail = labEmail
        this.birth = birth
        this.gender = gender
        this.firstName = firstName
        this.secondName = secondName
        this.address = address
        this.disease = disease
        this.testRecommendation = testRecommendation
        this.therapy = therapy
    }

    constructor() {}
}
