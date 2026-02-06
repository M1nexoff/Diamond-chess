import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DividerWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        VerticalDivider(modifier = Modifier.weight(1f))
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        VerticalDivider(modifier = Modifier.weight(1f))
    }
}
