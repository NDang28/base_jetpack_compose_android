package com.example.jetpackapp.widget.Button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedButton(
    width: Dp,
    height: Dp,
    backgroundColor: Color? = null,
    text: String? = null,
    textPadding: Dp = 0.dp,
    elevation: Dp = 4.dp, // Thêm tham số elevation
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        colors = if (backgroundColor != null) {
            ButtonDefaults.elevatedButtonColors(containerColor = backgroundColor)
        } else {
            ButtonDefaults.elevatedButtonColors() // Use default color
        },
        elevation = ButtonDefaults.elevatedButtonElevation(elevation),  // Set elevation
    ) {
        if (text != null) {
            Text(
                text = text,
                modifier = Modifier.padding(textPadding)
            )
        } else {
            // Text("Button")
        }
    }
}