plugins {
    id("java")
    id("io.freefair.lombok") version "6.5.1"
}

group = "co.uk.shopping"
version = "1.0-0"

repositories {
    mavenCentral()
}
object Versions {
    val lombok_version="1.18.20"
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    compileOnly( "org.projectlombok:lombok:${Versions.lombok_version}")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}