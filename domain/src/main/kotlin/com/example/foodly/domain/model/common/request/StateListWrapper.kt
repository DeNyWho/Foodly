package com.example.foodly.domain.model.common.request

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
sealed class StateListWrapper<out T> {
    data object Loading : StateListWrapper<Nothing>()
    data class Success<out T>(val data: ImmutableList<T>) : StateListWrapper<T>()
    data class Error(val error: ApiError) : StateListWrapper<Nothing>()

    companion object {
        fun <T> loading(): StateListWrapper<T> = Loading
        fun <T> success(data: ImmutableList<T>): StateListWrapper<T> = Success(data)
        fun <T> error(error: ApiError): StateListWrapper<T> = Error(error)
    }
}