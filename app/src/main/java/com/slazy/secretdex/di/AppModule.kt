package com.slazy.secretdex.di

import com.slazy.secretdex.data.network.PokemonApi
import com.slazy.secretdex.data.repository.PokemonRepositoryImpl
import com.slazy.secretdex.domain.repository.IPokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPokemonRepository(api: PokemonApi): IPokemonRepository = PokemonRepositoryImpl(api)
}