package com.alura.forum.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,

    @JsonIgnore
    @JoinTable(name = "users_role")
    @ManyToMany
    val role: List<Role> = mutableListOf()
)
