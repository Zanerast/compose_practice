package com.learning.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.compose.ui.theme.ComposeTheme

data class Art(
    val titleId: Int,
    val artistId: Int,
    val imageId: Int,
)

private val artData = listOf<Art>(
    Art(
        titleId = R.string.accessible_forward_image_title,
        artistId = R.string.accessible_forward_image_artist,
        imageId = R.drawable.ic_accessible_forward,
    ),
    Art(
        titleId = R.string.android_image_title,
        artistId = R.string.android_image_artist,
        imageId = R.drawable.ic_android,
    ),
    Art(
        titleId = R.string.launcher_image_title,
        artistId = R.string.launcher_image_artist,
        imageId = R.drawable.ic_launcher_background,
    )
)

@Composable
fun ArtSpace() {
    var index by remember { mutableStateOf(0) }
    val art = artData[index]
    val onClickNext = {
        index = if (index == artData.lastIndex) 0
        else ++index
    }
    val onClickPrevious = {
        index = if (index == 0) artData.lastIndex
        else --index
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtImage(art)
        ArtDetails(art)
        ArtButtons(onClickPrevious, onClickNext)
    }
}

@Composable
fun ArtImage(art: Art) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = art.imageId),
            contentDescription = stringResource(R.string.accessible_forward_image_title),
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ArtDetails(art: Art) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        modifier = Modifier
            .wrapContentWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp),
        ) {
            Text(
                text = stringResource(art.titleId),
                fontSize = 24.sp,
            )
            Text(
                text = stringResource(art.artistId),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ArtButtons(
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
) {
    val horizontalPadding = 32.dp
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
    ) {
        Button(
            content = { Text(text = stringResource(R.string.previous)) },
            onClick = { onClickPrevious() },
            modifier = Modifier
                .weight(1f)
        )
        Spacer(
            modifier = Modifier.width(horizontalPadding)
        )
        Button(
            content = { Text(text = stringResource(R.string.next)) },
            onClick = { onClickNext() },
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ComposeTheme {
        ArtSpace()
    }
}