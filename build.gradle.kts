plugins {
	kotlin("jvm") version "2.3.0-Beta2"
	kotlin("plugin.spring") version "2.3.0-Beta2"
	id("org.springframework.boot") version "4.0.0-RC1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "kotlin.context.parameters"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll(
			"-Xjsr305=strict",
			"-Xannotation-default-target=param-property",
			"-Xcontext-parameters",
		)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}