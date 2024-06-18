plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // springboot 버전 3.0 이상부터는 springfox-swagger 사용 불가  -> openapi-starter-webmvc 으로 대체
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // spring data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // mysql driver
    runtimeOnly("com.mysql:mysql-connector-j")
    // 하이버네이트 util (jakarta 같이 설치됨)
    implementation("io.hypersistence:hypersistence-utils-hibernate-60:3.3.2")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
