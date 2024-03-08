package com.example.apiluis.springkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinApplication>(*args)
	//SpringApplication.run(SpringKotlinApplication::class.java, *args)
}
