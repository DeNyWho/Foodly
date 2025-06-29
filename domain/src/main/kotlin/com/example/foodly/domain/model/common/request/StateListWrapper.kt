package com.example.foodly.domain.model.common.request

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class StateListWrapper<T>(
    val data: ImmutableList<T> = persistentListOf(),
    val isLoading: Boolean = false,
    val error: ApiError? = null,
) {
    companion object {
        inline fun <reified T> loading(): StateListWrapper<T> {
            return StateListWrapper(isLoading = true)
        }
    }
}