package com.example.apiluis.springkotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Wrestlers(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    var city: String,
    var promotion: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var slug: String = name.toSlug()
)