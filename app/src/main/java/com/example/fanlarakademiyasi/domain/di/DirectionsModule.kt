package com.example.fanlarakademiyasi.domain.di

import com.example.fanlarakademiyasi.presentation.direction.ChooseLanguageScreenDirection
import com.example.fanlarakademiyasi.presentation.direction.IntroScreenDirection
import com.example.fanlarakademiyasi.presentation.direction.MainScreenDirection
import com.example.fanlarakademiyasi.presentation.direction.SplashScreenDirection
import com.example.fanlarakademiyasi.presentation.direction.impl.ChooseLanguageScreenDirectionImpl
import com.example.fanlarakademiyasi.presentation.direction.impl.IntroScreenDirectionImpl
import com.example.fanlarakademiyasi.presentation.direction.impl.MainScreenDirectionImpl
import com.example.fanlarakademiyasi.presentation.direction.impl.SplashScreenDirectionImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionsModule {

    @Binds
    fun bindSplashScreen(impl: SplashScreenDirectionImpl): SplashScreenDirection

    @Binds
    fun bindIntroScreen(impl: IntroScreenDirectionImpl): IntroScreenDirection

    @Binds
    fun bindChooseLanguageScreen(impl: ChooseLanguageScreenDirectionImpl): ChooseLanguageScreenDirection

    @Binds
    fun bindMainScreen(impl: MainScreenDirectionImpl): MainScreenDirection
}