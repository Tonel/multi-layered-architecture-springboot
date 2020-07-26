package com.multilayered.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MultiLayeredApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val port = System.getenv("PORT") ?: "8080"
			val app = SpringApplication(MultiLayeredApplication::class.java)
			app.setDefaultProperties(
					mapOf("server.port" to port)
			)
			app.run(*args)
		}
	}
}
