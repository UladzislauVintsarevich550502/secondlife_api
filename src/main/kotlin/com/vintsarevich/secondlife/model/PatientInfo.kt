package com.vintsarevich.secondlife.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class PatientInfo(

    @Column
    var dateOfBirthday: Date,

    @Column
    var gender: String,

    @Column
    var firstName: String,

    @Column
    var secondName: String,

    @Column
    var address: String
) : AbstractEntity()