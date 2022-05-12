pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}

rootProject.name = "magnolia-runtime"

include("magnolia-core", "magnolia-api", "magnolia-legacy-api", "magnolia-server")
