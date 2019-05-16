package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
data class Lab(

    @Column
    var name: String,

    @ManyToMany
    @JoinTable(
        name = "lab_condition", joinColumns = [JoinColumn(name = "lab_id")],
        inverseJoinColumns = [JoinColumn(name = "condition_id")]
    )
    var conditions: List<Condition>,

    @Column
    var email: String
) : AbstractEntity()