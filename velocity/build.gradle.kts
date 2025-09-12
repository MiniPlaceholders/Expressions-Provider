dependencies {
    implementation(projects.expressionsCommon)
    compileOnly(libs.velocity.api)
    compileOnly(libs.miniplaceholders)
    annotationProcessor(libs.velocity.api)
}

