package com.hphl.rickandmorty.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hphl.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun RickAndMortyApp() {
    RickAndMortyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CharactersRoute(modifier = Modifier.padding(innerPadding))
        }
    }
}