package com.staygrateful.mbkmsample.ui.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LinearVertically() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Text 1", color = Color.White, modifier = Modifier.background(Color.Red))
        Text(text = "Text 2", color = Color.White, modifier = Modifier.background(Color.Blue))
        Text(text = "Text 3", color = Color.White, modifier = Modifier.background(Color.Green))
    }
}