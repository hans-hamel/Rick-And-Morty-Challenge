package com.hphl.rickandmorty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hphl.rickandmorty.domain.usecase.GetCharactersUseCase
import com.hphl.rickandmorty.presentation.state.CharactersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val uiState: StateFlow<CharactersUiState> = _uiState.asStateFlow()

    init {
        fetchCharacters()
    }

    fun fetchCharacters(page: Int = 1) {
        viewModelScope.launch {
            _uiState.value = CharactersUiState.Loading

            try {
                val result = getCharactersUseCase(page)

                _uiState.value = CharactersUiState.Success(characters = result.characters)
            } catch (exception: Exception) {
                _uiState.value = CharactersUiState.Error(
                    message = exception.message ?: "Unknown error"
                )
            }
        }
    }
}