package uz.m1nex.diamondchess.presenter.common.main.home

import uz.m1nex.diamondchess.data.model.User

data class HomeUiState(
    val user: User? = null,
    val isLoading: Boolean = false
)
