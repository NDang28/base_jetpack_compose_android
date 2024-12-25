package com.example.jetpackapp.widget.Button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun Button(
    width: Dp,
    height: Dp,
    backgroundColor: Color? = null,
    text: String? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        colors = if (backgroundColor != null) {
            ButtonDefaults.buttonColors(containerColor = backgroundColor)
        } else {
            ButtonDefaults.buttonColors() // Use default color
        }
    ) {
        if (text != null) {
            Text(text = text)
        } else {
            // If you want default text when none is passed
            // Text("Button")
        }
    }
}