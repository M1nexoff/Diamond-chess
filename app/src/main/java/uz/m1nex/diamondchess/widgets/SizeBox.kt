package uz.m1nex.diamondchess.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SizeBox(
    height: Int? = null,
    width: Int? = null
) {
    Spacer(
        modifier = Modifier
            .then(
                if (height != null) Modifier.height(height.dp)
                else Modifier
            )
            .then(
                if (width != null) Modifier.width(width.dp)
                else Modifier
            )
    )
}
