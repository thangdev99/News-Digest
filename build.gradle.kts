plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.modulegraph)
}

moduleGraphConfig {
    readmePath.set("./README.md")
    heading = "### Module Graph"
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        parallel = true
        buildUponDefaultConfig = true
        allRules = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
    }

    // Ensure Kotlin compiles target JVM 17 across all modules to avoid mismatched targets
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}
