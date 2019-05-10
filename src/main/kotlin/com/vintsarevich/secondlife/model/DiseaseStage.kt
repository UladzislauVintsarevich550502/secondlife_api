package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
data class DiseaseStage(

    @Column
    var name: String,

    @ManyToMany
    @JoinTable(name="disease_stage_condition", joinColumns= [JoinColumn(name= "disease_stage_id")],
        inverseJoinColumns = [JoinColumn(name="condition_id")])
    var conditions: List<Condition>
) : AbstractEntity()