package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.domain.usecase.SplashScreenUseCase
import com.example.fanlarakademiyasi.presentation.direction.SplashScreenDirection
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.SplashScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor(
    private val useCase: SplashScreenUseCase,
    private val direction: SplashScreenDirection
) : ViewModel(), SplashScreenViewModel {
    override fun navigate() {
        viewModelScope.launch {
            useCase.getIsFirst().collectLatest {
                delay(2500)
                if (it) {
                    useCase.getIsFirstIntro().collectLatest {
                        if (it) {
                            direction.openIntroScreen()
                        } else {
                            direction.openChooseLanguageScreen()
                        }
                    }
                } else {
                    direction.openMainScreen()
                }
            }
        }
    }
}