package uz.m1nex.diamondchess.presenter.common.main.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.delay

@Composable
fun AnimatedGameModeCard(
    index: Int,
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(index * 120L)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(400)) +
                slideInVertically(animationSpec = tween(400)) { it / 2 }
    ) {
        GameModeCard(
            icon = icon,
            title = title,
            description = description,
            onClick = onClick
        )
    }
}
