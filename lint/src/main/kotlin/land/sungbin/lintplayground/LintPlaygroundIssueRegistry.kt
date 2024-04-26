package land.sungbin.lintplayground

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class LintPlaygroundIssueRegistry : IssueRegistry() {
  override val vendor = Vendor(
    vendorName = "jisungbin",
    identifier = "land.sungbin.lintplayground",
    contact = "ji@sungb.in",
  )

  override val api = CURRENT_API

  override val issues = listOf<Issue>()
}
