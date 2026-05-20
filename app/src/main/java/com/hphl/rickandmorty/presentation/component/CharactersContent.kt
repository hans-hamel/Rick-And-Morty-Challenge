package com.hphl.rickandmorty.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hphl.rickandmorty.domain.model.CharacterModel
import com.hphl.rickandmorty.presentation.CharactersConstants.CHARACTER_RICK

@Composable
fun CharactersContent(
    characters: List<CharacterModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = characters,
            key = { it.id }
        ) { character ->
            CharacterItem(character)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CharactersContentPreview() {
    CharactersContent(
        characters = listOf(CHARACTER_RICK)
    )
}