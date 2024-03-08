package com.example.apiluis.springkotlin

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ArticleRepository : JpaRepository<Articles, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Articles>
    fun findBySlug(slug: String): Optional<Articles>

}
