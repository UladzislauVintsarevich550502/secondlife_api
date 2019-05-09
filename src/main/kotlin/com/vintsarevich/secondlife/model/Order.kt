package com.vintsarevich.secondlife.model

import javax.persistence.*

@Entity
@Table(name = "portal_order")
data class Order(

    @Column
    var name: String,

    @OneToOne
    @JoinColumn(name = "file_id")
    var file: File?,

    @OneToOne
    @JoinColumn(name = "doctor_id")
    var doctor: Doctor?,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: OrderStatus
) : AbstractEntity()