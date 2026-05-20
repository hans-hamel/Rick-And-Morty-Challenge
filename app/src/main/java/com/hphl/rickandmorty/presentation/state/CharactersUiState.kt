package com.hphl.rickandmorty.presentation.state

import com.hphl.rickandmorty.domain.model.PagedCharacters

sealed interface CharactersUiState {
    data object Loading : CharactersUiState
    data class Success(val pagedCharacters: PagedCharacters) : CharactersUiState
    data class Error(val message: String) : CharactersUiState
}