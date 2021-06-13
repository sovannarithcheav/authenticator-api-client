package kh.org.sora.authentication_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthenticationApiApplication

fun main(args: Array<String>) {
    runApplication<AuthenticationApiApplication>(*args)
}