package land.sungbin.lintplayground.rule

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.checks.infrastructure.TestLintTask

abstract class LintUnidenticalDetectorTest : LintDetectorTest() {
  override fun lint(): TestLintTask =
    super.lint().expectIdenticalTestModeOutput(false)
}
