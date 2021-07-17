package com.simple.repeat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RepeatApplication

fun main(args: Array<String>) {
	runApplication<RepeatApplication>(*args)
}
