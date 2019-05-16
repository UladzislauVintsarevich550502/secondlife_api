package com.vintsarevich.secondlife.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
data class Survey(

    @Column
    var name: String,

    @OneToOne
    @JoinColumn(name = "disease_id")
    var disease: Disease?,

    @OneToOne
    @JoinColumn(name = "disease_stage_id")
    var diseaseStage: DiseaseStage?,

    @OneToOne
    @JoinColumn(name = "therapy_id")
    var therapy: Therapy?,

    @OneToOne
    @JoinColumn(name = "test_recommendation_id")
    var testRecommendation: TestRecommendation?,

    @OneToOne
    @JoinColumn(name = "lab_id")
    var lab: Lab?
) : AbstractEntity()