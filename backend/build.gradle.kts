plugins {
    kotlin("jvm") version "2.3.20"
    kotlin("plugin.serialization") version "2.3.20"
    id("io.ktor.plugin") version "3.4.1"

}

kotlin {
    jvmToolchain(25)
}

group = "com.ndc"
version = "0.0.1"

application {
    mainClass.set("com.ndc.validator.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-cors-jvm")
    implementation("io.ktor:ktor-server-sse-jvm")
    implementation("io.modelcontextprotocol:kotlin-sdk:0.9.0")
    implementation("com.posthog:posthog-server:2.3.3")


    testImplementation("io.ktor:ktor-server-test-host:3.4.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
