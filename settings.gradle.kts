pluginManagement {
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

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

include(":core:model")
rootProject.name = "nowinandroid"
