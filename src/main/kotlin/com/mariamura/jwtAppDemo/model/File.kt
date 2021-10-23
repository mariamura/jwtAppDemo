package com.mariamura.jwtAppDemo.model

import javax.persistence.*

@Entity
@Table(name = "files")
data class File(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "path")
    val path: String
) {
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "events_id")
    var events: Event? = null
}
