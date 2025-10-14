package com.example.foodly.feature.detail

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.foodly.domain.usecase.recipe.RecipeInformationUseCase
import com.example.foodly.feature.detail.model.DetailAction
import com.example.foodly.feature.detail.model.DetailEvent
import com.example.foodly.feature.detail.model.DetailState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class DetailViewModel (
    private val recipeId: Int,
    private val recipeInformationUseCase: RecipeInformationUseCase,
) : ScreenModel {
    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<DetailAction>()
    val effect: SharedFlow<DetailAction> = _effect.asSharedFlow()

    init {
        handleIntent(DetailEvent.LoadInitialData)
    }

    fun handleIntent(detailIntent: DetailEvent) {
        when(detailIntent) {
            DetailEvent.LoadInitialData -> loadInitialData()
            DetailEvent.RefreshData -> refreshData()
        }
    }

    private fun loadInitialData() {
        screenModelScope.launch {
            launch { getRecipe(recipeId) }
        }
    }

    private fun getRecipe(recipeId: Int) {
        recipeInformationUseCase.invoke(
            id = recipeId,
            includeNutrition = true,
        ).onEach { result ->
            _state.update {
                it.copy(
                    recipe = result
                )
            }

        }.launchIn(screenModelScope)
    }

    private fun refreshData() {
        loadInitialData()
    }

}