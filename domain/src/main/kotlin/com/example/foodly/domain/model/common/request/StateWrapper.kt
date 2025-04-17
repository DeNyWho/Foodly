package com.example.foodly.domain.model.common.request

data class StateWrapper<T>(
    val data: T? = null,
    val isLoading: Boolean = false,
    val error: ApiError? = null,
) {
    companion object {
        inline fun <reified T> loading(): StateWrapper<T> {
            return StateWrapper(isLoading = true)
        }
    }
}