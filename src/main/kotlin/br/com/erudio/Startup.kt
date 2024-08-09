package br.com.erudio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class startup

fun main(args: Array<String>) {
	runApplication<startup>(*args)
}
