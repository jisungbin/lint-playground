@file:Suppress("UnstableApiUsage")

rootProject.name = "lint-playground"

pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex(".*google.*")
        includeGroupByRegex(".*android.*")
      }
    }
    mavenCentral()
    gradlePluginPortal()
  }
}

buildCache {
  local {
    removeUnusedEntriesAfterDays = 7
  }
}

include(":lint")
