package com.vintsarevich.secondlife.model

import org.hibernate.annotations.Type
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class File(
    @Column
    var name: String,

    @Column(columnDefinition = "blob")
    @Type(type = "org.hibernate.type.BinaryType")
    var data: ByteArray
):AbstractEntity()