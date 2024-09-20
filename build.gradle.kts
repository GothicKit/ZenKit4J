import java.util.*

plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
}

group = "dev.gothickit"
version = "1.0.2"


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

tasks.withType<Jar> {
    archiveBaseName.set("zenkit")
    archiveClassifier.set("")
    archiveVersion.set(version.toString())
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javadocJar by tasks.creating(Jar::class) {
    dependsOn.add(JavaPlugin.JAVADOC_TASK_NAME)
    archiveClassifier.set("javadoc")
    from(tasks["javadoc"])
}

fun getExtraString(name: String) = ext[name]?.toString()

publishing {
    repositories {
        maven {
            name = "SonatypeRelease"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
        maven {
            name = "SonatypeSnapshot"
            setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
        mavenLocal()
    }

    publications {
        create<MavenPublication>("main") {
            from(components.getByName("java"))
            artifact(javadocJar)
            artifact(sourcesJar)

            pom {
                name.set("ZenKit Java Bindings")
                description.set("Java bindings for ZenKit, the ZenGin Asset Parser")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("lmichaelis")
                        name.set("Luis Michaelis")
                        email.set("publishing@lmichaelis.de")
                        organization.set("GothicKit")
                        organizationUrl.set("https://github.com/GothicKit")
                    }
                }

                scm {
                    url.set("https://github.com/GothicKit/ZenKit4J")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}
