package com.example.jetpackapp.widget.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    width: Dp,
    height: Dp,
    backgroundColor: Color? = null,
    text: String? = null,
    textPadding: Dp = 0.dp, // Thêm tham số padding cho text
    icon: ImageVector? = null, // Thêm tham số cho icon
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height)
            .then(if (backgroundColor != null) Modifier.background(backgroundColor) else Modifier), // Thêm modifier background
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (text != null) {
                Text(text = text, modifier = Modifier.padding(textPadding))
            }
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null, // Bạn có thể tùy chỉnh content description
                    modifier = Modifier.size(iconSize)
                )
            }

        }
    }

}