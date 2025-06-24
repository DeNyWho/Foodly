pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}
rootProject.name = "Foodly"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")


include(":lint")
include(":domain")

include(":data:datastore")
include(":data:local")
include(":data:network")
include(":data:source")

include(":core:uikit")
include(":core:common")
include(":core:testing")

include(":feature:home")
include(":feature:favourite")
include(":feature:detail")
include(":feature:explore")
