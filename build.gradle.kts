import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.5.0"
	id("maven-publish")
	kotlin("plugin.spring") version "1.5.0"
}

java.sourceCompatibility = JavaVersion.VERSION_11
extra["springCloudVersion"] = "Hoxton.SR1"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// Soap
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.11.1")
	// Rest
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.json:json:20200518")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.4")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.11.4")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

apply {
	plugin("maven-publish")
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = project.properties["group"].toString()
			artifactId = project.name
			version = project.properties["version"].toString()
			from(components["kotlin"])
		}
	}
	repositories {
		maven {
			name = "GitHubPackages"
			url = uri("https://maven.pkg.github.com/sovannarithcheav/authenticator-api-client")
			credentials {
				username = "sovannarithcheav"
				password = "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"
			}
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
