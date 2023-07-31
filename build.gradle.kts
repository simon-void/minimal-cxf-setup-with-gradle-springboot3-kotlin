
plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    val kotlinVersion = "1.9.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

kotlin {
    // uses org.gradle.java.installations.auto-download=false in gradle.properties to disable auto provisioning of JDK
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {

    val jacksonVersion = "2.15.2"
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.jakarta.rs:jackson-jakarta-rs-json-provider:$jacksonVersion")

    val cxfVersion = "4.0.2"
    implementation("org.apache.cxf:cxf-spring-boot-starter-jaxrs:$cxfVersion")
}