package com.example.jetpackapp.widget.Button

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoadingButton(
    width: Dp,
    height: Dp,
    backgroundColor: Color? = null,
    text: String? = null,
    textPadding: Dp = 0.dp,
    onClick: suspend () -> Unit, // Thay đổi kiểu của onClick
) {
    var isLoading by remember { mutableStateOf(false) } // Theo dõi trạng thái loading
    val rotation by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing)
        ), label = ""
    )

    Button(
        onClick = {
            isLoading = true
            // Sử dụng coroutine để chạy function onClick
            // Chuyển sang trạng thái loading và chạy onClick
            // Vì onClick là suspend function chúng ta cần call bằng couroutine
            // Không có couroutine app sẽ bị crash
            // Lý do: Chúng ta không nên thực hiện các tác vụ nặng trên main thread
            CoroutineScope(Dispatchers.Main).launch {
                onClick()
                isLoading = false
            }
        },
        modifier = Modifier
            .width(width)
            .height(height),
        colors = if (backgroundColor != null) {
            ButtonDefaults.buttonColors(containerColor = backgroundColor)
        } else {
            ButtonDefaults.buttonColors() // Use default color
        },
        enabled = !isLoading
    ) {
        if (isLoading) {
            // Hiển thị icon loading
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .graphicsLayer { rotationZ = rotation },
            )
        } else {
            // Hiển thị text button
            if (text != null) {
                Text(text = text, modifier = Modifier.padding(textPadding))
            }
        }
    }
}