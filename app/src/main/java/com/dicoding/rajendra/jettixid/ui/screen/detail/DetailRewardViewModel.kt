package com.dicoding.rajendra.jettixid.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.rajendra.jettixid.data.RewardRepository
import com.dicoding.rajendra.jettixid.model.OrderReward
import com.dicoding.rajendra.jettixid.model.Movie
import com.dicoding.rajendra.jettixid.ui.common.UiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailRewardViewModel(
    private val repository: RewardRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderReward>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderReward>>
        get() = _uiState

    fun getRewardById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderRewardById(rewardId))
        }
    }

    fun addToCart(movie: Movie, count: Int) {
        viewModelScope.launch {
            repository.updateOrderReward(movie.id, count)
        }
    }
}