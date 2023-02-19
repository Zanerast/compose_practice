package com.learning.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.compose.ui.theme.ComposeTheme

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    ComposeTheme {
        Surface(color = Color.DarkGray) {
            BusinessCard()
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
        )
        Text(
            text = stringResource(id = R.string.business_card_name),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White,
            fontSize = 42.sp
        )
        Text(
            text = stringResource(id = R.string.business_card_android_dev),
            color = Color.Green,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp)
        )
    }
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(20.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.business_card_phone_number),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp
            )
        }
        
    }
}


