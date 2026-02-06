package uz.m1nex.diamondchess.presenter.common.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import uz.m1nex.diamondchess.data.model.*

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            delay(600)

            _uiState.value = HomeUiState(
                user = User(
                    name = "Madatbek",
                    rating = 1240,
                    stats = UserStats(
                        wins = 20,
                        losses = 5,
                        draws = 3
                    )
                ),
                isLoading = false
            )
        }
    }
}
