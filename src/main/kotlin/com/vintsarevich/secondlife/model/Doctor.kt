package com.vintsarevich.secondlife.model

import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Doctor(

    @Column
    var username: String,

    @Column
    var password: String,

    @Column
    var email: String,

    @Column
    var active: Boolean
) : AbstractEntity()