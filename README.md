# Authenticator API Client
Soramitsu Kotlin Library

ref: http://authenticatorapi.com

## Install

### build.gradle.kts:
1. Configure GitHub credential
```sh
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/sovannarithcheav/authenticator-api-client")
        credentials {
            username = System.getenv("GIT_PUBLISH_USER")
            password = System.getenv("GIT_PUBLISH_PASSWORD")
        }
    }
}
```
2. Add dependency
```sh
dependencies {
  	implementation("kh.org.soramitsu:authentication-client:${property("authentication-client-version")}")
}
```

3. Bean
```kotlin
@Configuration
@EnableFeignClients(clients = [AuthenticationClient::class])
@ComponentScan(basePackageClasses = [IAuthenticatorService::class])
class Config {}
```
