val detekt by configurations.creating

val detektTask = tasks.register<JavaExec>("detekt") {
    mainClass.set("io.gitlab.arturbosch.detekt.cli.Main")
    classpath = detekt

    val jvmTarget = "17"
    val input = projectDir
    val exclude = ".*/build/.*,.*/resources/.*,.*/buildSrc/.*"
    val report = "html:${buildDir.path}/reports/detekt.html"
    val params = listOf(
        "--parallel",
        "--jvm-target",
        jvmTarget,
        "--input",
        input,
        "--excludes",
        exclude,
        "-r",
        report,
    )

    args(params)
}

dependencies {
    detekt("io.gitlab.arturbosch.detekt:detekt-cli:1.23.1")
}
