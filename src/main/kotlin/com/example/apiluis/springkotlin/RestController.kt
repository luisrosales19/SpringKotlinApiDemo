package com.example.apiluis.springkotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/wrestlers")
class WrestlersController(val repository: WrestlerRepository) {


    @GetMapping
    fun wrestlers() = repository.findAllByOrderByCreatedAtDesc()

    @GetMapping("/{slug}")
    fun wrestlers(@PathVariable slug: String) =
        repository.findBySlug(slug).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND)}


    @PostMapping
    fun newWrestler(@RequestBody wrestler: Wrestlers):Wrestlers {
        wrestler.id = null
        repository.save(wrestler)
        return wrestler
    }

    @PutMapping("/{slug}")
    fun updateWrestler(@RequestBody wrestler: Wrestlers, @PathVariable slug: String): Wrestlers {
        val existingWrestler = repository.findBySlug(slug).orElseThrow {throw ResponseStatusException(HttpStatus.NOT_FOUND)}
        existingWrestler.city = wrestler.city
        existingWrestler.promotion = wrestler.promotion
        existingWrestler.slug = wrestler.slug
        repository.save(wrestler)
        return wrestler
    }

    @DeleteMapping("/{slug}")
    fun deleteWrestler(@PathVariable slug: String) {
        val existingWrestler = repository.findBySlug(slug).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND)}
        repository.delete(existingWrestler)
    }
}