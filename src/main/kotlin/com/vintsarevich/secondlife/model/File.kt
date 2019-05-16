package com.vintsarevich.secondlife.model

import org.hibernate.annotations.Type
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
data class File(
    @Column
    var name: String,

    @OneToOne
    @JoinColumn(name = "order_id")
    var order: Order?,

    @Column(columnDefinition = "blob")
    @Type(type = "org.hibernate.type.BinaryType")
    var data: ByteArray
):AbstractEntity()