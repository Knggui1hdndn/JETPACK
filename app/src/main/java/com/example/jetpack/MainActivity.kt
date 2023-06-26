package com.example.jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            preview()
            val fontFamily = FontFamily(
                Font(R.font.roboto_black, FontWeight.Black),
                Font(R.font.roboto_thin, FontWeight.Thin),
                Font(R.font.roboto_bold, FontWeight.Bold),
                Font(R.font.roboto_light, FontWeight.Light)

            )
            val colorState = remember {
                mutableStateOf(Color.Blue)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                        colorState.value = Color(
                            Random.nextFloat(),
                            Random.nextFloat(),
                            Random.nextFloat(),
                            1f
                        )
                    },
                ) {
                    Text(text = "Change text color")
                }
                CardImg(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    title = "Nguyễn duy khang",
                    fontFamily = fontFamily,
                    colorState=colorState.value
                )
            }

        }
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun CardImg(
        painter: Painter,
        title: String,
        fontFamily: FontFamily,
        colorState: Color
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .padding(20.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "ĐÂy là ảnh",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Blue),
                                    startY = 300f))
                    )
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Green,
                                        fontSize = 30.sp
                                    )
                                ) {
                                    append("N")
                                }
                                append("guyễn")

                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Green,
                                        fontSize = 30.sp
                                    )
                                ) {
                                    append(" K")
                                }
                                append("hang")
                            },
                            color = colorState,
                            modifier = Modifier.padding(30.dp),
                            fontSize = 20.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            style = TextStyle(textDecoration = TextDecoration.Underline)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun columnRow() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,//Chia đều khoảng cách tối đa giữa các view
            // verticalArrangement = Arrangement.SpaceAround,//Chia đều khoảng cách  các view nhưng vẫn thừa khoảng trống hai đầu
            // verticalArrangement = Arrangement.SpaceEvenly,//Chia đều khoảng cách các view và với lề theo hướng (ngang/dọc) bằng nhau

            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth(0.5f)//Chiều rộng bằng 50% chiều rộng màn hình


        ) {//Căn giữa bên view con theo chiều ngang
            Text(text = "Hello", color = Color.White, fontSize = 25.sp)
            Text(text = "Đây là Column", color = Color.White, fontSize = 25.sp)
            Row() {
                Text(text = "Hello", color = Color.White, fontSize = 25.sp)
                Text(text = "Đây là Row", color = Color.White, fontSize = 25.sp)
            }
        }
    }


}


