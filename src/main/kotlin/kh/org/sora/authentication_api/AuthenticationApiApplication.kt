package kh.org.sora.authentication_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AuthenticationApiApplication

fun main(args: Array<String>) {
    runApplication<AuthenticationApiApplication>(*args)
}