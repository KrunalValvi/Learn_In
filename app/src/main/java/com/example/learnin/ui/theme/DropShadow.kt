package com.example.learnin.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Predefined Shadow Styles
enum class ShadowStyle(val elevation: Dp) {
    Shadow1(2.dp),
    Shadow2(4.dp),
    Shadow3(8.dp),
    Shadow4(12.dp)
}

/**
 * A reusable composable to apply predefined shadow styles.
 *
 * @param modifier Modifier to customize layout behavior.
 * @param shadowStyle Predefined shadow style (e.g., Shadow1, Shadow2).
 * @param backgroundColor The color of the container.
 * @param padding Padding around the content.
 * @param content The content to be displayed inside the shadow.
 */
@Composable
fun DropShadow(
    modifier: Modifier = Modifier,
    shadowStyle: ShadowStyle,
    backgroundColor: Color = Color.White,
    padding: Dp = 8.dp,
    content: @Composable () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = shadowStyle.elevation),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(padding)
        ) {
            content()
        }
    }
}
