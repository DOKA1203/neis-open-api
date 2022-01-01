plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.github.doka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")

    implementation(kotlin("stdlib"))
}