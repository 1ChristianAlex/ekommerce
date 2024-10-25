val kotlin_version: String by project
val logback_version: String by project
val postgres_version: String by project
val h2_version: String by project
val koin_ktor: String by project
val ktor_version: String by project
val exposed: String by project
val mockito: String by project


val mockitoAgent = configurations.create("mockitoAgent")

plugins {
    kotlin("jvm") version "2.0.20"
    id("io.ktor.plugin") version "2.3.12"
    kotlin("plugin.serialization") version "2.0.20"
}

group = "example.com"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")

    // Ktor
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-request-validation:$ktor_version")
    implementation("io.ktor:ktor-server-cors-jvm")
    implementation("io.ktor:ktor-server-default-headers-jvm")
    implementation("io.ktor:ktor-server-compression-jvm")
    implementation("io.ktor:ktor-server-auth-jvm")
    implementation("io.ktor:ktor-server-auth-jwt-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-config-yaml")


    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Datetime
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")

    //    Koin
    implementation(platform("io.insert-koin:koin-bom:$koin_ktor"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-ktor")


    // Database
    implementation("org.jetbrains.exposed:exposed-core:$exposed")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposed")
    implementation("org.postgresql:postgresql:$postgres_version")

    // Hashing
    implementation("org.mindrot:jbcrypt:0.4")


    // Testing

    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    testImplementation("org.mockito:mockito-core:$mockito")
    mockitoAgent("org.mockito:mockito-core:$mockito") { isTransitive = false }

}
ktor {
    fatJar {
        archiveFileName.set("fat.jar")
    }
}
tasks {
    test {
        jvmArgs("-javaagent:${mockitoAgent.asPath}")
    }
}