package com.learning.compose

import android.icu.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.learning.compose.ui.theme.ComposeTheme
import org.junit.Rule
import org.junit.Test

class TipCalculatorTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate20PercentTip() {
        composeTestRule.setContent {
            ComposeTheme {
                TipTimeScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }

}