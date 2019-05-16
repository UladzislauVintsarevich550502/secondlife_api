package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
data class Therapy(

    @Column
    var name: String,

    @ManyToMany
    @JoinTable(
        name = "therapy_condition", joinColumns = [JoinColumn(name = "therapy_id")],
        inverseJoinColumns = [JoinColumn(name = "condition_id")]
    )
    var conditions: List<Condition>
) : AbstractEntity()