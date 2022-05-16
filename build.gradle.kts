import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "org.uwu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sksamuel.scrimage:scrimage-core:4.0.31")
    implementation("com.formdev:flatlaf:2.2")
    testImplementation(kotlin("test"))
}


tasks.apply {
    test {
        useJUnitPlatform()
    }

    withType<AbstractArchiveTask> {
        isReproducibleFileOrder = true
        isPreserveFileTimestamps = false
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

application {
    mainClass.set("org.uwu.MainKt")
}