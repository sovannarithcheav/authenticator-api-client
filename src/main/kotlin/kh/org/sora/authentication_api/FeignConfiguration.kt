package kh.org.sora.authentication_api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignConfiguration {
    @Bean
    fun feignLoggerLevel(): feign.Logger.Level {
        return feign.Logger.Level.BASIC
    }
}