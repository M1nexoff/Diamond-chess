package uz.m1nex.diamondchess.presenter.common.main.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SectionTitle(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
//            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
