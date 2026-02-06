import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.m1nex.diamondchess.presenter.common.main.MainScreen
import uz.m1nex.diamondchess.presenter.common.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppRouter() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }
        composable("main") {
            MainScreen()
        }
    }
}
