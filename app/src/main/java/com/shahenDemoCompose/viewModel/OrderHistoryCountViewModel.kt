package com.shahenDemoCompose.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.shahenDemoCompose.model.request.OrderHistoryCountRequest
import com.shahenDemoCompose.model.response.BaseResponse
import com.shahenDemoCompose.model.response.OrderHistoryCountResponse
import com.shahenDemoCompose.repository.OrderHistoryCountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OrderHistoryViewModel @Inject constructor(private val repository: OrderHistoryCountRepository) : ViewModel() {

    private val _isLoadingState = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean>
        get() = _isLoadingState.asStateFlow()

    private val _orderHistoryCountState = MutableStateFlow<OrderHistoryCountResponse?>(null)
    val orderHistoryCountState: StateFlow<OrderHistoryCountResponse?>
        get() = _orderHistoryCountState.asStateFlow()

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?>
        get() = _errorState.asStateFlow()

    fun getOrderHistoryCount(section: String) {
        viewModelScope.launch {


            try {
                val response = repository.callApiOrderHistoryCount(OrderHistoryCountRequest(section))
                when (response) {
                    is BaseResponse.Success -> {
                        _isLoadingState.emit(false)
                        _orderHistoryCountState.emit(response.data)
                    }
                    is BaseResponse.Error -> {
                        _errorState.emit(response.msg ?: "An unexpected error occurred")
                    }
                    is BaseResponse.Loading ->{
                        _isLoadingState.emit(true)
                    }

                    else -> {}
                }
            } catch (e: Exception) {
                Log.e("OrderHistoryViewModel", "Error fetching order history count: ${e.message}", e)
                _errorState.emit(e.message ?: "An unexpected error occurred")
            } finally {
                _isLoadingState.emit(false)
            }
        }
    }
}