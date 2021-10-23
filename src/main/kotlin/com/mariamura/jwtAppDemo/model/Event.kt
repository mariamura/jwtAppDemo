package com.mariamura.jwtAppDemo.model

import javax.persistence.*

@Entity
@Table(name = "events")
data class Event(
    @Id
    @Column(name = "id", nullable = false)
    var id: Long,

    @OneToOne(mappedBy = "events", fetch = FetchType.EAGER)
    val file: File
)
