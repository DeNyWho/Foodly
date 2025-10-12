package com.example.foodly.feature.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.RecipeSort
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType
import com.example.foodly.domain.usecase.recipe.RecipesByQueryUseCase
import com.example.foodly.feature.home.model.HomeAction
import com.example.foodly.feature.home.model.HomeEvent
import com.example.foodly.feature.home.model.HomeState
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

internal class HomeViewModel(
    private val recipesByQueryUseCase: RecipesByQueryUseCase,
) : ScreenModel {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val _action = MutableSharedFlow<HomeAction>()
    val action: SharedFlow<HomeAction> = _action.asSharedFlow()

    init {
        handleEvent(HomeEvent.LoadInitialData)
    }

    fun handleEvent(intent: HomeEvent) {
        when(intent) {
            HomeEvent.LoadInitialData -> loadInitialData()
            HomeEvent.RefreshData -> refreshData()
            is HomeEvent.UpdateMealType -> updateMealType(intent.mealType)
            is HomeEvent.OnRecipeCardClick -> onRecipeCardClick(intent.recipeId)
        }
    }

    private fun loadInitialData() {
        screenModelScope.launch {
            launch { getMealTypeRecipes() }
            launch { getPopularRecipes() }
            launch { getFastRecipes() }
            launch { getHealthyRecipes() }
        }
    }

    private fun onRecipeCardClick(recipeId: Int) = screenModelScope.launch {
        _action.emit(
            HomeAction.NavigateToRecipeDetail(recipeId)
        )
    }

    private fun getMealTypeRecipes() {
        recipesByQueryUseCase.invoke(
            type = _state.value.currentMealType.value,
        ).onEach { result ->
            _state.update {
                it.copy(
                    fastRecipes = result
                )
            }
        }.launchIn(screenModelScope)
    }

    private fun getPopularRecipes() {
        recipesByQueryUseCase.invoke(
            sort = RecipeSort.Popular.value,
        ).onEach { result ->
            _state.update {
                it.copy(
                    popularRecipes = result
                )
            }
        }.launchIn(screenModelScope)
    }

    private fun getFastRecipes() {
        recipesByQueryUseCase.invoke(
            sort = RecipeSort.Popular.value,
            maxReadyTime = 30,
        ).onEach { result ->
            _state.update {
                it.copy(
                    fastRecipes = result
                )
            }
        }.launchIn(screenModelScope)
    }

    private fun getHealthyRecipes() {
        recipesByQueryUseCase.invoke(
            sort = RecipeSort.Health.value,
        ).onEach { result ->
            _state.update {
                it.copy(
                    healthyRecipes = result
                )
            }
        }.launchIn(screenModelScope)
    }

    private fun updateMealType(mealType: RecipeMealType) {
        _state.update {
            it.copy(
                currentMealType = mealType,
                mealTypeRecipes = StateListWrapper.loading()
            )
        }

        getMealTypeRecipes()
    }

    private fun refreshData() {
        loadInitialData()
    }

}