package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lesstion_1.model.User

class Lists : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userList = listOf(
                User(1, "John", 25),
                User(2, "Jane", 30),
                User(3, "Mike", 28),
                User(4, "Emily", 32),
                User(5, "David", 27),
                User(6, "Sarah", 29),
                User(7, "Mark", 31),
                User(8, "Linda", 26),
                User(9, "Chris", 33),
                User(10, "Amy", 24)
            )
            LazyColumn {
                itemsIndexed(userList) { _: Int, user: User ->
                    Text(
                        text = "Item $user", modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.3f)
                            .padding(15.dp)
                            .background(Color.Gray),
                        color = Color.Black,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }
}
