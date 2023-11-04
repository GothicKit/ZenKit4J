import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.gothickit"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("net.java.dev.jna:jna:5.13.0")
    implementation("org.jetbrains:annotations:24.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("zenkit")
    archiveClassifier.set("")
    archiveVersion.set("0.0.1")
}

publishing {
    publications {
        create<MavenPublication>("shadow") {
            project.shadow.component(this)
        }
    }
}

