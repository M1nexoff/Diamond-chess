package uz.m1nex.diamondchess.presenter.common.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = viewModel()
    ) {
    LaunchedEffect(Unit) {

        delay(
            timeMillis = 2000
        )
        if(viewModel.uiState.value.isLogin)
            navController.navigate("main") {
                popUpTo("splash") { inclusive = true }
            }
        else
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "♞",
                fontSize = 96.sp,)
//            Spacer(
//                modifier = Modifier.height(14.dp)
//            )
            Text(
                "Splash",

            )

        }
    }
}