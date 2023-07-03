package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class SimpleAnimations : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState,
                //Tạo một TweenSpec được định cấu hình với thời lượng, độ trễ và đường cong nới lỏng nhất định.
                tween(
                    durationMillis = 1000,
                    delayMillis = 0,
                    easing = FastOutLinearInEasing
                )
                //Tạo độ nảy cho animation
//                spring(
//                    Spring.DefaultDisplacementThreshold
//                )
                //Chỉ đình hoạt ảnh và kích thước tại mỗi thời điểm riêng
//                keyframes {
//                    durationMillis = 5000
//                    sizeState at 0 with LinearEasing
//                    sizeState * 1.5f at 1000 with FastOutLinearInEasing//chậm lúc đầu và cực đại về cuôi
//                    sizeState * 2f at 5000
//                }
            )
            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = { sizeState += 50.dp }) {
                    Text(text = "Increase Size")

                }
            }
        }
    }
}
