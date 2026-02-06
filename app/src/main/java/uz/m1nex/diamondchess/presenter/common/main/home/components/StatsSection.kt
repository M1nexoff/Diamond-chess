package uz.m1nex.diamondchess.presenter.common.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.m1nex.diamondchess.data.model.User
import uz.m1nex.diamondchess.widgets.SizeBox

@Composable
fun StatsSection(
    user: User,
    winPercent: Int
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        Text(
            text = "Ваша статистика",
            style = MaterialTheme.typography.titleLarge
        )

        SizeBox(
            height = 16
        )

        Card(
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem("Побед", user.stats.wins)
                    StatItem("Поражений", user.stats.losses)
                    StatItem("Ничьих", user.stats.draws)
                }

                SizeBox(
                    height = 16
                )

                HorizontalDivider()

                SizeBox(
                    height = 16
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Процент побед")
                    Text("$winPercent%")
                }
            }
        }
    }

}
