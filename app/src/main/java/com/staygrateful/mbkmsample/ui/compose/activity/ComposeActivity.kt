package com.staygrateful.mbkmsample.ui.compose.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staygrateful.mbkmsample.R
import com.staygrateful.mbkmsample.extension.colorResources
import com.staygrateful.mbkmsample.ui.compose.component.*
import com.staygrateful.mbkmsample.ui.compose.theme.MBKMSampleTheme

class ComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            MBKMSampleTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .background(colorResource(R.color.primary))
                        ) {
                            Text(
                                text = "Top navigation",
                                fontSize = 16.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxWidth()
                            )
                        }
                    },
                    bottomBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .background(Color.DarkGray)
                        ) {
                            Text(
                                text = "Bottom navigation",
                                fontSize = 16.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxWidth()
                            )
                        }
                    }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .verticalScroll(scrollState)
                    ) {
                        TextTitle(title = "Column (Linear Vertically)")
                        LinearVertically()
                        TextTitle(title = "Row (Linear Horizontally)")
                        LinearHorizontally()
                        TextTitle(title = "Box")
                        SimpleBox()
                        TextTitle(title = "Constraint")
                        ConstraintLayoutContent()
                        TextTitle(title = "Constraint 2")
                        DecoupledConstraintLayout()
                    }
                }
            }
        }
    }
}

@Composable
fun TextTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        color = Color.DarkGray,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MBKMSampleTheme {
        //Greeting("Android")
    }
}