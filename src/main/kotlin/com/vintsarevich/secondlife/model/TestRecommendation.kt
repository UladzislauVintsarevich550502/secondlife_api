package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
data class TestRecommendation(

    @Column
    var name: String,

    @ManyToMany
    @JoinTable(
        name = "test_recommendation_condition", joinColumns = [JoinColumn(name = "test_recommendation_id")],
        inverseJoinColumns = [JoinColumn(name = "condition_id")]
    )
    var conditions: List<Condition>
) : AbstractEntity()