import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.m1nex.diamondchess.presenter.common.main.home.HomeViewModel
import uz.m1nex.diamondchess.presenter.common.main.home.components.AnimatedGameModeCard
import uz.m1nex.diamondchess.presenter.common.main.home.components.HomeHeader
import uz.m1nex.diamondchess.presenter.common.main.home.components.SectionTitle
import uz.m1nex.diamondchess.presenter.common.main.home.components.StatsSection
import uz.m1nex.diamondchess.ui.theme.DiamondChessTheme
import uz.m1nex.diamondchess.ui.theme.StaticColors
import uz.m1nex.diamondchess.widgets.SizeBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    var visible by remember { mutableStateOf(false) }
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        delay(3 * 120L)
        visible = true
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    val user = state.user ?: return

    val winPercent = remember(user) {
        val total = user.stats.wins + user.stats.losses + user.stats.draws
        if (total == 0) 0
        else ((user.stats.wins.toFloat() / total) * 100).toInt()
    }
    DiamondChessTheme{
        Scaffold(
            topBar= {
                HomeHeader(
                    user = user,
                    onProfileClick = {
                        navController.navigate("profile")
                    },
                    onSettingsClick = {
                        navController.navigate("settings")
                    }
                )
            },
            modifier = Modifier.fillMaxSize()
        ) {padding->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {



                item {
                    SizeBox(
                        height = 24
                    )
                }

                item {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(500)) +
                                slideInVertically(animationSpec = tween(500)) { it / 2 }
                    ) {
                        SectionTitle(
                            title = "Выберите режим игры",
                            subtitle = "Начните новую партию"
                        )
                    }
                }

                item {
                    SizeBox(
                        height = 16
                    )
                }

                item {
                    AnimatedGameModeCard(
                        boxColor = StaticColors.Blue,
                        index = 0,
                        icon = Icons.Default.Computer,
                        title = "Играть с компьютером",
                        description = "Выберите уровень сложности"
                    ) {
//                navController.navigate("game_setup/ai")
                    }
                }

                item {
                    AnimatedGameModeCard(
                        boxColor = StaticColors.Green,
                        index = 1,
                        icon = Icons.Default.Public,
                        title = "Онлайн игра",
                        description = "Играть со случайным соперником"
                    ) {
//                navController.navigate("game_setup/online")
                    }
                }

                item {
                    AnimatedGameModeCard(
                        boxColor = StaticColors.Purple,
                        index = 2,
                        icon = Icons.Default.Group,
                        title = "Игра с другом",
                        description = "На одном устройстве"
                    ) {
//                navController.navigate("game_setup/local")
                    }
                }

                item {
                    SizeBox(
                        height = 32
                    )
                }

                item {
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(animationSpec = tween(400)) +
                                slideInVertically(animationSpec = tween(400)) { it / 2 }
                    ) {
                        StatsSection(
                            user = user,
                            winPercent = winPercent
                        )
                    }
                }

                item {
                    SizeBox(
                        height = 32
                    )
                }
            }
        }
    }


}
