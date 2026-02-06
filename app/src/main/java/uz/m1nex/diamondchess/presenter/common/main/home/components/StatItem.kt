
package uz.m1nex.diamondchess.presenter.common.main.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun StatItem(
    label: String,
    value: Int,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.headlineSmall,
            color=color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color=MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
