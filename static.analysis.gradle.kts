apply(from = "kotlin-static-analysis-tools/detekt/detekt.setup.gradle.kts")
apply(from = "kotlin-static-analysis-tools/ktlint/ktlint.setup.gradle.kts")

project.run {
    val detektCheck = rootProject.tasks.plus(tasks).firstOrNull { it.name == "detekt" }
    val hookTask = tasks.firstOrNull { it.name == "preBuild" || it.name == "testClasses" }
    hookTask?.run { detektCheck?.let { dependsOn(it) } }
}
