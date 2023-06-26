package com.example.jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Textfields_Buttons_Showing_Snackbars : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Scaffold  cung cấp các bố cục thuận tiện cho việc kết hợp các thành
            // phần Material vào các mẫu màn hình phổ biến
            // như TopAppBar ,BottomAppBar ,drawerContent...
            val snackBarHostState = remember { SnackbarHostState() }
            val textState = remember { mutableStateOf("") }

            Scaffold(modifier = Modifier.fillMaxSize(),
                snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textState.value,
                        onValueChange = { textState.value = it },
                        label = {
                            Text(text = "Nguyễn Khang")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(onClick = {
                        CoroutineScope(Dispatchers.Main).launch {
                            val result = snackBarHostState.showSnackbar(
                                message = textState.value,
                                actionLabel = "UNDO",
                                withDismissAction = true,
                                duration = SnackbarDuration.Short
                            )

                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    mToast("Click UNDO")
                                }

                                SnackbarResult.Dismissed -> {
                                    mToast("Click Dismissed")
                                }
                            }
                        }
                    }) {
                        Text(text = "Button")
                    }
                }
            }
        }

    }

    fun mToast(s: String) {
        Toast.makeText(this@Textfields_Buttons_Showing_Snackbars, s, Toast.LENGTH_SHORT).show()
    }
}



