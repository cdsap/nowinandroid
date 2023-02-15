import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin.Companion.isInfoAsWarnings

/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
        maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }

}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.secrets) apply false
    id("io.github.cdsap.testprocess") version "0.1"
}


allprojects {
    tasks.withType<Test>().configureEach {
        maxParallelForks = System.getenv("MAX_PARALLEL_FORKS").toInt()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {


        doLast {
            var x = ""
            this@configureEach.classpathSnapshotProperties.classpath.forEach {
                x += it.path+ ";"
            }
            rootProject.buildScan.value(
            "${this@configureEach.path}-kotlinJavaToolchainProvider",
            "${this@configureEach.kotlinJavaToolchainProvider.get().javaVersion.get()}"
            )
            rootProject.buildScan.value(
                "${this@configureEach.path}-isInfoAsWarnings",
                "${this@configureEach.kotlinJavaToolchainProvider.get().toolchain.toString()}"
            )
            rootProject.buildScan.value(
                "${this@configureEach.path}-usePreciseJavaTracking",
                "${this@configureEach.usePreciseJavaTracking}"
            )
            rootProject.buildScan.value(
                "${this@configureEach.path}-usePreciseclasspathSnapshotPropertiesuseClasspathSnapshot",
                "${this@configureEach.classpathSnapshotProperties.useClasspathSnapshot.get()}"
            )
            rootProject.buildScan.value(
                "${this@configureEach.path}-serializedCompilerArguments",
                "${this@configureEach.serializedCompilerArguments.toString()}"
            )

            rootProject.buildScan.value(
                "${this@configureEach.path}-classpath",
                "${x}"
            )

            rootProject.buildScan.value(
                "${this@configureEach.path}-size",
                "${this@configureEach.pluginOptions.get().size}"
            )

            rootProject.buildScan.value(
                "${this@configureEach.path}-size",
                "${this@configureEach.pluginOptions.get().size}"
            )
            this@configureEach.pluginOptions.get().forEach {

                println(it.getAsTaskInputArgs().size)
                println(it.allOptions().size)
                rootProject.buildScan.value(
                    "${this@configureEach.path}-inputs",
                    "${it.toString()}"
                )
                rootProject.buildScan.value(
                    "${this@configureEach.path}-inputs-allOptions",
                    "${it.allOptions().toString()}"
                )
                rootProject.buildScan.value(
                    "${this@configureEach.path}-inputs-getAsTaskInputArgs",
                    "${it.getAsTaskInputArgs().toString()}"
                )

                it.allOptions().forEach{
                    rootProject.buildScan.value(
                        "${this@configureEach.path}",
                        it.value.joinToString(",")
                    )
                }
            }


        }
    }
}
