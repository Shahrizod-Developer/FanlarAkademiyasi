package com.example.fanlarakademiyasi.domain.di


import com.example.fanlarakademiyasi.domain.usecase.*
import com.example.fanlarakademiyasi.domain.usecase.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {


    @Binds
    fun bindSplashScreenUseCase(impl: SplashScreenUseCaseImpl): SplashScreenUseCase

    @Binds
    fun bindIntroScreenUseCase(impl: IntroScreenUseCaseImpl): IntroScreenUseCase

    @Binds
    fun bindHomeScreenUseCase(impl: HomeScreenUseCaseImpl): HomeScreenUseCase

    @Binds
    fun bindChooseLanguageScreenUseCase(impl: ChooseLanguageScreenUseCaseImpl): ChooseLanguageScreenUseCase

    @Binds
    fun bindMainActivityUseCase(impl: MainActivityUseCaseImpl): MainActivityUseCase

    @Binds
    fun bindAcademyOfSciencesPageUseCase(impl: AcademyOfSciencesPageUseCaseImpl): AcademyOfSciencesPageUseCase

}