package com.example.foodly.domain.model.common.request

import androidx.compose.runtime.Immutable

@Immutable
sealed class StateWrapper<out T> {
    data object Loading: StateWrapper<Nothing>()
    data class Success<out T>(val data: T): StateWrapper<T>()
    data class Error(val error: ApiError): StateWrapper<Nothing>()

    companion object {
        fun <T> loading(): StateWrapper<T> = Loading
        fun <T> success(data: T): StateWrapper<T> = Success(data)
        fun <T> error(error: ApiError): StateWrapper<T> = Error(error)
    }
}