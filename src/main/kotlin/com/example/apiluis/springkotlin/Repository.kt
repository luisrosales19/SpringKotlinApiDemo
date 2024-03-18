package com.example.apiluis.springkotlin

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface WrestlerRepository : JpaRepository<Wrestlers, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Wrestlers>
    fun findBySlug(slug: String): Optional<Wrestlers>

}