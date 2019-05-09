package com.vintsarevich.secondlife

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecondlifeApplication

fun main(args: Array<String>) {
	runApplication<SecondlifeApplication>(*args)
}
