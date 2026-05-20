package com.hphl.rickandmorty.di

import com.hphl.rickandmorty.data.repository.CharactersRepositoryImpl
import com.hphl.rickandmorty.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: CharactersRepositoryImpl
    ): CharactersRepository
}