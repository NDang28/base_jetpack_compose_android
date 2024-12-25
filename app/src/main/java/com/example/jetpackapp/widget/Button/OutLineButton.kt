package com.example.jetpackapp.widget.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OutlineButton(
    width: Dp,
    height: Dp,
    backgroundColor: Color? = null,
    text: String? = null,
    textColor: Color? = null,
    borderColor: Color? = null, // Màu viền
    borderWidth: Dp = 1.dp,     // Độ dày viền
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        colors = if (backgroundColor != null) {
            ButtonDefaults.outlinedButtonColors(containerColor = backgroundColor)
        } else {
            ButtonDefaults.outlinedButtonColors() // Use default color
        },
        border = BorderStroke(
            width = borderWidth,
            color = borderColor ?: Color.Gray // Use Gray by default if borderColor is not provided
        )
    ) {
        if (text != null) {
            Text(
                text = text,
                color = textColor
                    ?: Color.White // Use White by default if textColor is not provided
            )
        } else {
            // If you want default text when none is passed
            // Text("Button")
        }
    }
}