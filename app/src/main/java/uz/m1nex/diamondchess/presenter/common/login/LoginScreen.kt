import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import uz.m1nex.diamondchess.widgets.SizeBox

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.loginSuccess) {
        if (state.loginSuccess) {
//            snackbarHostState.showSnackbar("Добро пожаловать!")
            navController.navigate("main") {
                popUpTo("login") { inclusive = true }
            }
        }
    }

    LaunchedEffect(state.errorMessage) {
        state.errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearError()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimatedVisibility(visible = true) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "♞",
                        fontSize = 64.sp
                    )

                    SizeBox(height = 16)

                    Text(
                        text = "Добро пожаловать",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text(
                        text = "Войдите, чтобы начать игру",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            SizeBox(height = 32)

            EmailField(
                value = state.email,
                error = state.emailError,
                onValueChange = viewModel::onEmailChange
            )

            SizeBox(height = 16)

            PasswordField(
                value = state.password,
                error = state.passwordError,
                onValueChange = viewModel::onPasswordChange
            )

            SizeBox(height = 8)

            Text(
                text = "Забыли пароль?",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
//                        navController.navigate("forgot")
                    }
            )

            SizeBox(height = 24)

            Button(
                onClick = { viewModel.login() },
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isLoading
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                    Text("Войти")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            DividerWithText("или")

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = { viewModel.showInfo("Google вход в разработке") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Google")
                }

                OutlinedButton(
                    onClick = { viewModel.showInfo("Apple вход в разработке") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Apple")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row {
                Text("Нет аккаунта? ")

                Text(
                    text = "Зарегистрироваться",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
//                        navController.navigate("register")
                    }
                )
            }
        }
    }
}
