import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("kapt") version "1.3.72"
}

group = "com.multilayered.springboot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-web:2.3.1.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.1.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-validation:2.3.1.RELEASE")
	implementation ("org.hibernate:hibernate-jpamodelgen:5.4.12.Final")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	implementation("mysql:mysql-connector-java:8.0.20")
	implementation("org.mapstruct:mapstruct-jdk8:1.3.1.Final")
	kapt("org.mapstruct:mapstruct-processor:1.3.1.Final")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	kapt("org.hibernate:hibernate-jpamodelgen:5.4.12.Final")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
