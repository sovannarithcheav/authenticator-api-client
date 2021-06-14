plugins {
}

dependencies {
    implementation("org.springframework:spring-context:5.2.3.RELEASE")
    compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.4")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.11.4")
    implementation("org.json:json:20200518")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.11.4")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("io.github.openfeign:feign-core:10.10.1")
    implementation("org.springframework.cloud:spring-cloud-openfeign-core:2.2.1.RELEASE")
}