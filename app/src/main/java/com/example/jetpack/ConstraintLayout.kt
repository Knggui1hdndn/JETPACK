package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpack.ui.theme.JetpackTheme

class ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    //  width = Dimension.fillToConstraints// lấp đầy chiều rộng hoặc cao
                    height = Dimension.value(100.dp)
                    width = Dimension.value(100.dp)
                }
                //     createHorizontalChain(greenBox, redBox)
                //     căn chỉnh theo chiều ngang một cách tự động và
                //     có thể có các khoảng cách giữa chúng cân đối.
                createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
                //chainStyle thay đổi kiểu căn chỉnh
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenBox")
                ) {

                }
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redBox")
                ) {

                }
            }
        }
    }
}
