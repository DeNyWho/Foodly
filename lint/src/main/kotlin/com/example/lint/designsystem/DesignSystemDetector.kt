package com.example.lint.designsystem

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UQualifiedReferenceExpression

class DesignSystemDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> = listOf(
        UCallExpression::class.java,
        UQualifiedReferenceExpression::class.java,
    )

    override fun createUastHandler(context: JavaContext): UElementHandler =
        object : UElementHandler() {
            override fun visitCallExpression(node: UCallExpression) {
                val name = node.methodName ?: return
                val preferredName = METHOD_NAMES[name] ?: return
                reportIssue(context, node, name, preferredName)
            }

            override fun visitQualifiedReferenceExpression(node: UQualifiedReferenceExpression) {
                val name = node.receiver.asRenderString()
                val preferredName = RECEIVER_NAMES[name] ?: return
                reportIssue(context, node, name, preferredName)
            }
        }

    companion object {
        @JvmField
        val ISSUE: Issue = Issue.create(
            id = "DesignSystem",
            briefDescription = "Design system",
            explanation = "This check highlights calls in code that use Compose Material " +
                "composables instead of equivalents from the Foodly design system " +
                "module.",
            category = Category.CUSTOM_LINT_CHECKS,
            priority = 7,
            severity = Severity.ERROR,
            implementation = Implementation(
                DesignSystemDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )

        val METHOD_NAMES = mapOf(
            "MaterialTheme" to "FoodlyTheme",
            "Button" to "FoodlyButton",
            "OutlinedButton" to "FoodlyOutlinedButton",
            "TextButton" to "FoodlyTextButton",
            "FilterChip" to "FoodlyFilterChip",
            "ElevatedFilterChip" to "FoodlyFilterChip",
            "Icon" to "FoodlyIcon",
            "NavigationBar" to "FoodlyNavigationBar",
            "NavigationBarItem" to "FoodlyNavigationBarItem",
            "TabRow" to "FoodlyTabRow",
            "Tab" to "FoodlyTab",
            "IconToggleButton" to "FoodlyIconToggleButton",
            "FilledIconToggleButton" to "FoodlyIconToggleButton",
            "FilledTonalIconToggleButton" to "FoodlyIconToggleButton",
            "OutlinedIconToggleButton" to "FoodlyIconToggleButton",
            "CenterAlignedTopAppBar" to "FoodlyTopAppBar",
            "SmallTopAppBar" to "FoodlyTopAppBar",
            "MediumTopAppBar" to "FoodlyTopAppBar",
            "LargeTopAppBar" to "FoodlyTopAppBar",
        )

        val RECEIVER_NAMES = mapOf(
            "Icons" to "FoodlyIcons",
        )

        fun reportIssue(
            context: JavaContext,
            node: UElement,
            name: String,
            preferredName: String,
        ) {
            context.report(
                ISSUE,
                node,
                context.getLocation(node),
                "Using $name instead of $preferredName",
            )
        }
    }
}