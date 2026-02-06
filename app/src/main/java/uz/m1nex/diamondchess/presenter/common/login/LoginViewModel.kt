import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.m1nex.diamondchess.data.sourse.shared.MyShar
import uz.m1nex.diamondchess.presenter.common.login.LoginUiState


class LoginViewModel : ViewModel() {
    private val myShar :MyShar = MyShar.getInstance()

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value, emailError = null) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value, passwordError = null) }
    }

    fun login() {
        val state = _uiState.value
        var emailError: String? = null
        var passwordError: String? = null

        if (state.email.isBlank()) {
            emailError = "Введите email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            emailError = "Неверный формат email"
        }

        if (state.password.isBlank()) {
            passwordError = "Введите пароль"
        } else if (state.password.length < 6) {
            passwordError = "Пароль должен быть не менее 6 символов"
        }

        if (emailError != null || passwordError != null) {
            _uiState.update {
                it.copy(emailError = emailError, passwordError = passwordError)
            }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            delay(1500)

            if (state.email == "test@test.com" && state.password == "123456") {
                myShar.isLogin=true
                _uiState.update {
                    it.copy(isLoading = false, loginSuccess = true)
                }

            } else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Неверный email или пароль"
                    )
                }
            }
        }
    }

    fun showInfo(message: String) {
        _uiState.update { it.copy(errorMessage = message) }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}
