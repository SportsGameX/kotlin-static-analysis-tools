val ktlint by configurations.creating

dependencies {
    ktlint("com.pinterest.ktlint:ktlint-cli:1.0.0") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
    // ktlint(project(":custom-ktlint-ruleset")) // in case of custom ruleset
}

val outputDir = "${project.layout.buildDirectory}/reports/ktlint/"
val inputFiles = projectDir

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(
        inputFiles,
    )
    outputs.dir(outputDir)

    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    val composeRules = "$rootDir/kotlin-static-analysis-tools/ktlint/ktlint-compose-0.3.0-all.jar"
    val editorConfig = "$rootDir/kotlin-static-analysis-tools/ktlint/.editorconfig"
    val params =
        listOf(
            "--editorconfig",
            editorConfig,
            "-R",
            composeRules,
            "--format",
        )
    args = params + listOf("**/src/**/*.kt", "**.kts", "!**/build/**", "!**/resources/**")
}

val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style and format"
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    jvmArgs("--add-opens=java.base/java.lang=ALL-UNNAMED")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args = listOf("-F", "**/src/**/*.kt", "**.kts", "!**/build/**")
}
