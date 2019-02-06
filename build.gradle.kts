import org.springframework.boot.gradle.tasks.run.BootRun

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.1.2.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.3.20")
    }

    repositories {
        mavenCentral()
        jcenter()
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.20")
    id("org.jetbrains.kotlin.plugin.spring").version("1.3.20")
    id("org.springframework.boot").version("2.0.6.RELEASE")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    compile("org.springframework.boot:spring-boot-starter-web:2.1.2.RELEASE")

    compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.20")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.20")

    compile("com.squareup.okhttp3:okhttp:3.6.0")
}

tasks.withType<BootRun> {
    main = "StocknessMonster.AppKt"
}
