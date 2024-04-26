import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:8.3.2")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
  }
}

subprojects {
  repositories {
    google {
      content {
        includeGroupByRegex(".*google.*")
        includeGroupByRegex(".*android.*")
      }
    }
    mavenCentral()
  }

  afterEvaluate {
    tasks.withType<KotlinCompile> {
      kotlinOptions {
        jvmTarget = "17"
      }
    }
  }
}
