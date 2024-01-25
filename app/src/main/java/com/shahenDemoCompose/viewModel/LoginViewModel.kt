package com.shahenDemoCompose.viewModel

import android.preference.PreferenceManager
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.gson.JsonObject
import com.shahenDemoCompose.comon.isEmailValid
import com.shahenDemoCompose.comon.isPasswordValid
import com.shahenDemoCompose.model.request.LoginRequest
import com.shahenDemoCompose.model.response.BaseResponse
import com.shahenDemoCompose.model.response.LoginResponse
import com.shahenDemoCompose.repository.LoginRepository
import com.shahenDemoCompose.state.TextFieldState
import com.shahenDemoCompose.util.Home_Route
import com.shahenDemoCompose.util.OrderHistoryCount_Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    private val _isLoadingState = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean>
        get() = _isLoadingState.asStateFlow()

    private val _emailState = mutableStateOf(TextFieldState(text = "shahen.requester@shahenexpress.com"))
    val emailState: State<TextFieldState> = _emailState

    fun setEmail(value: String) {
        _emailState.value = emailState.value.copy(text = value, error = "")
    }

    private val _passwordState = mutableStateOf(TextFieldState(text = "ShahenBv@2023"))
    val passwordState: State<TextFieldState> = _passwordState

    fun setPassword(value: String) {
        _passwordState.value = passwordState.value.copy(text = value, error = "")
    }

    private val _loginErrorMsg = MutableStateFlow("")
    val loginErrorMsg: StateFlow<String>
        get() = _loginErrorMsg.asStateFlow()

    fun setLoginErrorMsg(value: String) {
        _loginErrorMsg.value = value
    }

    fun isValid(onLoginSuccess: () -> Unit) {
        if (_emailState.value.text.isEmpty()) {
            _emailState.value = _emailState.value.copy(error = "Please enter Email ID")
        } else if (!_emailState.value.text.isEmailValid()) {
            _emailState.value = _emailState.value.copy(error = "Invalid Email ID")
        } else if (_passwordState.value.text.isEmpty()) {
            _passwordState.value = _passwordState.value.copy(error = "Please enter Password")
        } else if (!_passwordState.value.text.isPasswordValid()) {
            _passwordState.value =
                _passwordState.value.copy(error = "Password should be between 8 to 30 characters")
        } else {
            LoginStatus(
                LoginRequest(
                    role = "service_requester",
                    email = emailState.value.text,
                    password = passwordState.value.text,
                ),
                onLoginSuccess
            )
        }
    }

    private fun LoginStatus(model: LoginRequest, onLoginSuccess: () -> Unit) {
        viewModelScope.launch {


            try {
                when (val result = loginRepository.callApiLOGIN(model)) {
                    is BaseResponse.Success -> {
                        _isLoadingState.emit(false)
                        _loginErrorMsg.emit("")
                        val loginResponse = result.data?.data
                        onLoginSuccess.invoke()
                    }

                    is BaseResponse.Error -> {
                        _loginErrorMsg.emit(result.msg ?: "An unexpected error occurred")
                        Log.d("LoginErrorState", "Data is not loaded")
                    }

                    is BaseResponse.Loading -> {
                        _isLoadingState.emit(true)
                        // Handle loading state if needed
                    }

                    is BaseResponse.ErrorMsg<*> -> {
                        _loginErrorMsg.emit(result.errorMessage ?: "An unexpected error occurred")
                    }
                }
            } catch (e: Exception) {
                _loginErrorMsg.emit(e.message ?: "An unexpected error occurred")
                Log.d("LoginErrorState", "Data is not loaded")
            } finally {
                _isLoadingState.emit(false)
            }
        }
    }
}