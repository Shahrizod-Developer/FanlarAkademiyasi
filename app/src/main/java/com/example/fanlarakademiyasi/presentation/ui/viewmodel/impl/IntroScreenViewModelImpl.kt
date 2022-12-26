package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.data.model.IntroData
import com.example.fanlarakademiyasi.domain.usecase.IntroScreenUseCase
import com.example.fanlarakademiyasi.presentation.direction.IntroScreenDirection
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.IntroScreenViewModel
import com.example.fanlarakademiyasi.presentation.utils.flow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModelImpl @Inject constructor(
    private val useCase: IntroScreenUseCase,
    private val direction: IntroScreenDirection
) : IntroScreenViewModel, ViewModel() {
    override val introDataList = flow<List<IntroData>>()
    override val currentItemFlow = flow<Int>()

    init {
        viewModelScope.launch {
            useCase.getIntroData().collectLatest {
                introDataList.emit(it)
            }
        }
    }

    override fun onClickSkip() {
        viewModelScope.launch {
            useCase.setIsFirstIntro(false)
            direction.openChooseLanguageScreen()
        }
    }

    override fun onClickNext(currentItem: Int) {

        viewModelScope.launch {
            when (currentItem) {
                0 -> {
                    currentItemFlow.emit(1)
                }
                1 -> {
                    currentItemFlow.emit(2)
                }
                2 -> {
                    useCase.setIsFirstIntro(false)
                    direction.openChooseLanguageScreen()
                }
            }
        }
    }
}