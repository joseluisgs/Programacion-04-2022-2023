plugins {
    id("java")
}

group = "es.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

// Para hacer un JAR ejecutable
tasks.jar {
    manifest {
        // Aquí se pone el nombre del fichero que tiene el método main
        // que queremos que se lance
        // si se llama Main.java, se pone Main, si se llama Otro.java, se pone Otro
        // ojo poner el paquete desde la raíz que es java
        attributes["Main-Class"] = "Main"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}