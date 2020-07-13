plugins {
    kotlin("jvm")
    `maven`
}

group = "dev.joelparrish.ktor"

repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.exposed:exposed-core:0.26.1")
}

java {
    withSourcesJar()
}