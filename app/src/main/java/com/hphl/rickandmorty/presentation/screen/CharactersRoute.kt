package com.hphl.rickandmorty.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hphl.rickandmorty.presentation.viewmodel.CharactersViewModel

@Composable
fun CharactersRoute(
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CharactersScreen(
        uiState = uiState,
        onRetry = viewModel::fetchCharacters,
        modifier = modifier
    )
}