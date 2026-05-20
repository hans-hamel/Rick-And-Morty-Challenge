package com.hphl.rickandmorty.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("info")
    val info: InfoDto,
    @SerializedName("results")
    val results: List<CharacterDto>
)