plugins {
    kotlin("jvm") version "1.5.10"
    java
}

group = "com.github.DevSanso.payment"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("io.ktor:ktor-server-core-jvm:2.0.0-beta-1")
    implementation("io.ktor:ktor-server-netty-jvm:2.0.0-beta-1")
    implementation("io.ktor:ktor-server-status-pages-jvm:2.0.0-beta-1")
    implementation("io.ktor:ktor-server-default-headers-jvm:2.0.0-beta-1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.3.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}