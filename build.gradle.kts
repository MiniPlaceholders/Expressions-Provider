plugins {
    java
    alias(libs.plugins.shadow)
}

allprojects {
    apply<JavaPlugin>()
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))

    tasks.withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }
}

dependencies {
    implementation(projects.expressionsCommon)
    implementation(projects.expressionsVelocity)
    implementation(projects.expressionsPaper)
    implementation(projects.expressionsSponge)
    implementation(projects.expressionsFabric)
}

tasks {
    shadowJar {
        archiveFileName.set("Expressions-${project.version}.jar")
        archiveClassifier.set("")
        doLast {
            copy {
                from(archiveFile)
                into("${rootProject.projectDir}/build")
            }
        }
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
