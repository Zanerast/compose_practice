package com.learning.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.compose.ui.theme.ComposeTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskManagerPreview() {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            TaskManager(
                title = stringResource(id = R.string.task_manager_title),
                content = stringResource(id = R.string.task_manager_content),
                centreIcon = painterResource(id = R.drawable.ic_task_completed),
            )
        }
    }
}

@Composable
fun TaskManager(
    title: String,
    content: String,
    centreIcon: Painter
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = centreIcon,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = content,
            fontSize = 16.sp,
        )
    }
}