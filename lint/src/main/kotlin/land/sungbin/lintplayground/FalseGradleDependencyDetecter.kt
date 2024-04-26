package land.sungbin.lintplayground

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.GradleContext
import com.android.tools.lint.detector.api.GradleScanner
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Incident
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

class FalseGradleDependencyDetecter : Detector(), GradleScanner {
  override fun getApplicableFiles() = Scope.GRADLE_SCOPE

  private val validConfigurationNames = listOf("implementation", "api")

  override fun checkDslPropertyAssignment(
    context: GradleContext,
    property: String,
    value: String,
    parent: String,
    parentParent: String?,
    valueCookie: Any,
    statementCookie: Any,
  ) {
    if (parent == "dependencies" && property in validConfigurationNames) {
      if (value.count { it == ':' } != 2) return
      val (group, artifact, _) = GradleContext.getStringLiteralValue(value, valueCookie)!!.split(':')

      if (property == "implementation" && group == "com.android.tools.lint" && artifact == "lint-api") {
        val location = context.getLocation(valueCookie)
        Incident(context, issue = ISSUE)
          .location(location)
          .scope(location.source)
          .message("Do not use com.android.tools.lint:lint-api as a 'implementation'.")
          .report()
      }
    }
  }

  companion object {
    @JvmField
    val ISSUE = Issue.create(
      id = "FalseGradle",
      briefDescription = "Detect false gradle dependency",
      explanation = "This detector checks if there is a false gradle dependency.",
      category = Category.CORRECTNESS,
      priority = 8,
      severity = Severity.ERROR,
      implementation = Implementation(FalseGradleDependencyDetecter::class.java, Scope.GRADLE_SCOPE),
    )
  }
}
