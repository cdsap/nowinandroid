buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
       // maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }

}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
  //  alias(libs.plugins.secrets) apply false
  //  id("io.github.cdsap.testprocess") version "0.1"
}

//
//allprojects {
//    tasks.withType<Test>().configureEach {
//        maxParallelForks = System.getenv("MAX_PARALLEL_FORKS").toInt()
//    }
//
//    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
//
//
//        doLast {
//
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-freeCompilerArgs",
//                "${this@configureEach.compilerOptions.freeCompilerArgs.get().joinToString(",")}"
//            )
//
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-compilerOptions",
//                "${this@configureEach.compilerOptions.toString()}"
//            )
//
//
//
//
//            var x = ""
//            this@configureEach.classpathSnapshotProperties.classpath.forEach {
//                x += it.path+ ";"
//            }
//            rootProject.buildScan.value(
//            "${this@configureEach.path}-kotlinJavaToolchainProvider",
//            "${this@configureEach.kotlinJavaToolchainProvider.get().javaVersion.get()}"
//            )
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-isInfoAsWarnings",
//                "${this@configureEach.kotlinJavaToolchainProvider.get().toolchain.toString()}"
//            )
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-usePreciseJavaTracking",
//                "${this@configureEach.usePreciseJavaTracking}"
//            )
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-usePreciseclasspathSnapshotPropertiesuseClasspathSnapshot",
//                "${this@configureEach.classpathSnapshotProperties.useClasspathSnapshot.get()}"
//            )
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-serializedCompilerArguments",
//                "${this@configureEach.serializedCompilerArguments.toString()}"
//            )
//
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-classpath",
//                "${x}"
//            )
//
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-size",
//                "${this@configureEach.pluginOptions.get().size}"
//            )
//
//            rootProject.buildScan.value(
//                "${this@configureEach.path}-size",
//                "${this@configureEach.pluginOptions.get().size}"
//            )
//            this@configureEach.pluginOptions.get().forEach {
//
//                println(it.getAsTaskInputArgs().size)
//                println(it.allOptions().size)
//                rootProject.buildScan.value(
//                    "${this@configureEach.path}-inputs",
//                    "${it.toString()}"
//                )
//                rootProject.buildScan.value(
//                    "${this@configureEach.path}-inputs-allOptions",
//                    "${it.allOptions().toString()}"
//                )
//                rootProject.buildScan.value(
//                    "${this@configureEach.path}-inputs-getAsTaskInputArgs",
//                    "${it.getAsTaskInputArgs().toString()}"
//                )
//
//                it.allOptions().forEach{
//                    rootProject.buildScan.value(
//                        "${this@configureEach.path}",
//                        it.value.joinToString(",")
//                    )
//                }
//            }
//
//
//        }
//    }
//}
