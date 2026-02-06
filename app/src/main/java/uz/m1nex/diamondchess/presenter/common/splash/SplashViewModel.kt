package uz.m1nex.diamondchess.presenter.common.splash

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uz.m1nex.diamondchess.data.sourse.shared.MyShar

class SplashViewModel: ViewModel() {
    private val myShar :MyShar = MyShar.getInstance()

    var _uiState= MutableStateFlow(SplashUIState(isLogin = myShar.isLogin))

    val uiState: StateFlow<SplashUIState> = _uiState
}