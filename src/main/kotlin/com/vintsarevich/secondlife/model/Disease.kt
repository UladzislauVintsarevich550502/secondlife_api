package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
data class Disease(

    @Column
    var name: String,

    @ManyToMany
    @JoinTable(name="disease_condition", joinColumns= [JoinColumn(name= "disease_id")],
        inverseJoinColumns = [JoinColumn(name="condition_id")])
    var conditions: List<Condition>
) : AbstractEntity()