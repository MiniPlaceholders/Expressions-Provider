plugins {
    alias(libs.plugins.runpaper)
}

dependencies {
    implementation(projects.expressionsCommon)
    compileOnly(libs.paper.api)
}

tasks {
    processResources {
        filesMatching("paper-plugin.yml") {
            expand("version" to project.version)
        }
    }
}
