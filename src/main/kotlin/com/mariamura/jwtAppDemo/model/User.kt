package com.mariamura.jwtAppDemo.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "username")
    val name: String,

    @Column(name = "password")
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: Status,

    @LastModifiedDate
    @Column(name = "updated")
    val updated: Date,

    @CreatedDate
    @Column(name = "created")
    val created: Date,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val events: List<Event>? = null,

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "roles_id")]
    )
    val roles: List<Role> = listOf()

)
