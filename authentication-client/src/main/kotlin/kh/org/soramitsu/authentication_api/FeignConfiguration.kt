package kh.org.soramitsu.authentication_api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class FeignConfiguration {
    @Bean
    open fun feignLoggerLevel(): feign.Logger.Level {
        return feign.Logger.Level.BASIC
    }
}