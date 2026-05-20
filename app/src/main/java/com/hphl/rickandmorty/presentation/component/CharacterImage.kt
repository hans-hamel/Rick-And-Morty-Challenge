package com.hphl.rickandmorty.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.hphl.rickandmorty.R
import com.hphl.rickandmorty.domain.model.CharacterModel
import com.hphl.rickandmorty.presentation.CharactersConstants.CHARACTER_RICK

@Composable
fun CharacterImage(
    character: CharacterModel,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(character.image)
            .crossfade(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .build(),
        contentDescription = character.name,
        modifier = modifier
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp)),
        content = {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    Image(
                        painter = painterResource(R.drawable.rick_and_morty_placeholder),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                is AsyncImagePainter.State.Error -> {
                    Image(
                        painter = painterResource(R.drawable.rick_and_morty_error),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                else -> {
                    SubcomposeAsyncImageContent(
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun CharacterImagePreview() {
    CharacterImage(
        character = CHARACTER_RICK
    )
}
