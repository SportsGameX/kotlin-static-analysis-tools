val detekt by configurations.creating

val detektTask =
    tasks.register<JavaExec>("detekt") {
        dependsOn("ktlintCheck")
        mainClass.set("io.gitlab.arturbosch.detekt.cli.Main")
        classpath = detekt

        val jvmTarget = "17"
        val input = projectDir
        val config = "$rootDir/kotlin-static-analysis-tools/detekt/detekt.yml"
        val exclude = ".*/build/.*,.*/resources/.*,**/buildSrc/**,**/resources/**"
        val report = "html:${buildDir.path}/reports/detekt.html"
        val detektCompose = "$rootDir/kotlin-static-analysis-tools/detekt/detekt-compose-0.3.0-all.jar"
        val detektFormatting = "$rootDir/kotlin-static-analysis-tools/detekt/detekt-formatting-1.23.1.jar"
        val params =
            listOf(
                "--parallel",
                "--jvm-target",
                jvmTarget,
                "--input",
                input,
                "--config",
                config,
                "--excludes",
                exclude,
                "-r",
                report,
                "--auto-correct",
                "--plugins",
                "$detektCompose, $detektFormatting",
            )

        args(params)
    }

dependencies {
    detekt("io.gitlab.arturbosch.detekt:detekt-cli:1.23.1")
}
