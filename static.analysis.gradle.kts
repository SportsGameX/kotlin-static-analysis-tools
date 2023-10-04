apply(from = "kotlin-static-analysis-tools/detekt/detekt.setup.gradle.kts")
apply(from = "kotlin-static-analysis-tools/ktlint/ktlint.setup.gradle.kts")

project.run {
    // Get the first project/module
    val firstProject = if (subprojects.isNotEmpty()) {
        subprojects.filter { proj: Project -> proj.subprojects.isEmpty() }.firstOrNull()
    } else {
        project
    }

    // Attach detekt and ktlint to run before first project/module
    firstProject?.run {
        val detektCheck = rootProject.tasks.plus(tasks).firstOrNull { it.name == "detekt" }
        val ktlintCheck = rootProject.tasks.plus(tasks).firstOrNull { it.name == "ktlintCheck" }
        val hookTask = tasks.firstOrNull { it.name == "preBuild" || it.name == "testClasses" }
        hookTask?.run {
            detektCheck?.let { dependsOn(it) }
            ktlintCheck?.let { dependsOn(it) }
        }
    }
}
