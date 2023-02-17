import java.net.URI

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
 * See the Lixcense for the specific language governing permissions and
 * limitations under the License.
 */

pluginManagement {
  //  includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.gradle.common-custom-user-data-gradle-plugin") version "1.8.1"
    id("com.gradle.enterprise") version "3.11.1"

}
//enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
gradleEnterprise {
    server = "https://ge.solutions-team.gradle.com"
    allowUntrustedServer = true
    buildScan {
        publishAlways()
        capture {
            isTaskInputFiles = true
        }
        isUploadInBackground = System.getenv("CI") == null
    }
}


//buildCache {
//    registerBuildCacheService(
//        androidx.build.gradle.gcpbuildcache.GcpBuildCache::class,
//        androidx.build.gradle.gcpbuildcache.GcpBuildCacheServiceFactory::class
//    )
//    remote(androidx.build.gradle.gcpbuildcache.GcpBuildCache::class) {
//        projectId = "cache-node"
//        bucketName = "cache-node"
//        credentials =
//            androidx.build.gradle.gcpbuildcache.ExportedKeyGcpCredentials(File("cache-node.json"))
//        isPush = System.getenv("CI") != null
//    }
//}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

//include(":app")
//include(":app-nia-catalog")
//include(":benchmark")
//include(":core:common")
//include(":core:data")
//include(":core:data-test")
//include(":core:database")
//include(":core:datastore")
//include(":core:datastore-test")
//include(":core:designsystem")
include(":core:model")
//include(":core:navigation")
//include(":core:network")
//include(":core:ui")
//include(":core:testing")
//include(":feature:author")
//include(":feature:foryou")
//include(":feature:interests")
//include(":feature:bookmarks")
//include(":feature:topic")
//include(":lint")
//include(":sync:work")
//include(":sync:sync-test")
rootProject.name = "nowinandroid"
