pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MeditationUiApp"
include(":app")
include(":library:designsystem")
include(":domain:menu")
include(":feauter:bottomMenu")
include(":feauter:currentsection")
