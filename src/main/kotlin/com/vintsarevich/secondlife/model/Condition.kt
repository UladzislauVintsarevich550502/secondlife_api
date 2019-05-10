package com.vintsarevich.secondlife.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
data class Condition(

    @Column
    var negative: Boolean,

    @Column
    var name: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var type: ConditionType
) : AbstractEntity()