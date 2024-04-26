plugins {
  kotlin("jvm")
  id("com.android.lint")
}

tasks.test {
  useJUnitPlatform()
}

dependencies {
  compileOnly("com.android.tools.lint:lint-api:31.3.2")

  testImplementation("com.android.tools.lint:lint:31.3.2")
  testImplementation("com.android.tools.lint:lint-tests:31.3.2")

  testImplementation("junit:junit:4.13.2")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.2")
}
