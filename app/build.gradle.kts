plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  namespace = "land.sungbin.lintplayground.app"
  compileSdk = 34
}

dependencies {
  implementation("com.android.tools.lint:lint-api:31.3.2")
  lintChecks(project(":lint"))
}
