package com.hphl.rickandmorty.presentation.state

import com.hphl.rickandmorty.domain.model.CharacterModel

sealed interface CharactersUiState {
    data object Loading : CharactersUiState
    data class Success(val characters: List<CharacterModel>) : CharactersUiState
    data class Error(val message: String) : CharactersUiState
}