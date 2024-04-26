package land.sungbin.lintplayground._source

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.kotlin
import com.android.tools.lint.checks.infrastructure.TestFile
import java.io.File

@Suppress("NOTHING_TO_INLINE")
inline fun sourceFile(filename: String): TestFile =
  kotlin(File("src/test/kotlin/land/sungbin/lintplayground/_source/$filename").readText())
