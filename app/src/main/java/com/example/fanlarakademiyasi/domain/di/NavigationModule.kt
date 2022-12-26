package com.example.fanlarakademiyasi.domain.di

import com.example.fanlarakademiyasi.presentation.navigation.NavigationDispatcher
import com.example.fanlarakademiyasi.presentation.navigation.NavigationHandler
import com.example.fanlarakademiyasi.presentation.navigation.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun navigator(dispatcher: NavigationDispatcher): Navigator

    @Binds
    fun navigatorHandler(dispatcher: NavigationDispatcher): NavigationHandler
}