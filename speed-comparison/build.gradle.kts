plugins {
    kotlin("jvm")
}

dependencies {
    compile(project(":core"))
    compile("org.nield:kotlin-statistics:1.1.3")
    compile("org.koin:koin-core:1.0.1")
    compile("org.kodein.di:kodein-di-erased-jvm:5.3.0")
}

val fatJar = task("fatJar", type = Jar::class) {
    baseName = "${project.name}-fat"
    manifest {
        attributes["Main-Class"] = "org.rewedigital.katana.comparison.ComparisonKt"
    }
    from(configurations.runtime.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}
