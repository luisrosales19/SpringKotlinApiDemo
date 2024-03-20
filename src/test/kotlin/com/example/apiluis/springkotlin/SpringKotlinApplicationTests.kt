package com.example.apiluis.springkotlin

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import kotlin.collections.isNotEmpty


@SpringBootTest
class WrestlerRepositoryTests {

	@Autowired
	lateinit var wrestlerRepository: WrestlerRepository

	@Test
	fun `test findAllByOrderByCreatedAtDesc`() {
		val wrestlers = wrestlerRepository.findAllByOrderByCreatedAtDesc()
		assertNotNull(wrestlers) { "List of wrestlers should not be empty" }
	}

	@Test
	fun `test findBySlug with existing slug`() {
		val existingSlug = "existing-slug"
		val wrestler = Wrestlers(id = 1, name = "Test Wrestler", city = "Test City", promotion = "Test Promotion", slug = existingSlug)
		wrestlerRepository.save(wrestler)

		val foundWrestler = wrestlerRepository.findBySlug(existingSlug)
		assert(foundWrestler.isPresent) { "Wrestler with slug $existingSlug should be found" }
		assert(foundWrestler.get().name == "Test Wrestler") { "Found wrestler's name should be a match" }
	}

	@Test
	fun `test findBySlug with non-existing slug`() {
		val nonExistingSlug = "non-existing-slug"
		val foundWrestler = wrestlerRepository.findBySlug(nonExistingSlug)
		assert(foundWrestler.isEmpty) { "No wrestler should be found for slug $nonExistingSlug" }
	}
}

