package com.learning.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.compose.ui.theme.ComposeTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    ComposeTheme {
        Quadrant(
            topRightTitle = stringResource(id = R.string.quadrant_top_right_title),
            topRightMessage = stringResource(id = R.string.quadrant_top_right_message),
            bottomLeftTitle = stringResource(id = R.string.quadrant_bottom_left_title),
            bottomLeftMessage = stringResource(id = R.string.quadrant_bottom_left_message),
            bottomRightTitle = stringResource(id = R.string.quadrant_bottom_right_title),
            bottomRightMessage = stringResource(id = R.string.quadrant_bottom_right_message),
        )
    }
}

@Composable
fun Quadrant(
    topRightTitle: String,
    topRightMessage: String,
    bottomLeftTitle: String,
    bottomLeftMessage: String,
    bottomRightTitle: String,
    bottomRightMessage: String,
) {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(2f)) {
            QuadrantCard(
                title = stringResource(id = R.string.quadrant_top_left_title),
                message = stringResource(id = R.string.quadrant_top_left_message),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = topRightTitle,
                message = topRightMessage,
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = bottomLeftTitle,
                message = bottomLeftMessage,
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = bottomRightTitle,
                message = bottomRightMessage,
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    message: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify
        )
    }
}
