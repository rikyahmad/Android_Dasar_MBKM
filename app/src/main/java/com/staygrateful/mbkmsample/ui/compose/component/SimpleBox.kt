package com.staygrateful.mbkmsample.ui.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.LightGray),
    ) {
        Text(
            text = "Box 1",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .size(300.dp, 300.dp)
                .align(Alignment.Center)
                .background(Color.Red)
        )
        Text(
            text = "Box 2",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .size(200.dp, 200.dp)
                .align(Alignment.Center)
                .background(Color.Blue)
        )
        Text(
            text = "Box 3",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .size(100.dp, 100.dp)
                .align(Alignment.Center)
                .background(Color.Green)
        )
    }
}