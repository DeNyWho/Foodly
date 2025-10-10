package com.example.foodly.domain.usecase.recipe

import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.repository.recipe.RecipesRepository
import kotlinx.coroutines.flow.Flow

class QuickAnswerUseCase(private val recipesRepository: RecipesRepository) {
    operator fun invoke(q: String): Flow<StateWrapper<String>> {
        return recipesRepository.quickAnswer(q)
    }
}