package com.hphl.rickandmorty.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hphl.rickandmorty.presentation.component.CharactersContent
import com.hphl.rickandmorty.presentation.component.ErrorContent
import com.hphl.rickandmorty.presentation.component.LoadingContent
import com.hphl.rickandmorty.presentation.state.CharactersUiState

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    uiState: CharactersUiState,
    onRetry: () -> Unit
) {
    when (uiState) {
        is CharactersUiState.Loading -> {
            LoadingContent(modifier)
        }


        is CharactersUiState.Success -> {
            CharactersContent(
                characters = uiState.characters,
                modifier = modifier
            )
        }


        is CharactersUiState.Error -> {
            ErrorContent(
                message = uiState.message,
                onRetry = onRetry,
                modifier = modifier
            )
        }
    }
}