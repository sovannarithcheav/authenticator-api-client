import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("maven-publish")
	kotlin("jvm") version "1.4.21-2"
}

allprojects {

	apply {
		plugin("org.jetbrains.kotlin.jvm")
	}
	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
	}
	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	}
	java.sourceCompatibility = JavaVersion.VERSION_11

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	apply {
		plugin("maven-publish")
	}

	publishing {
		publications {
			create<MavenPublication>("maven") {
				groupId = project.properties["group"].toString()
				artifactId = project.name
				version = project.properties["version"].toString()
				from(components["java"])
			}
		}
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
	}
}

dependencies {
	implementation(project(":authentication-client"))
	implementation("org.springframework.boot:spring-boot-starter-web")
}