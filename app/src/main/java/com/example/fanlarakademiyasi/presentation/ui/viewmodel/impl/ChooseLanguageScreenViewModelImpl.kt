package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.domain.usecase.ChooseLanguageScreenUseCase
import com.example.fanlarakademiyasi.presentation.direction.ChooseLanguageScreenDirection
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.ChooseLanguageScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChooseLanguageScreenViewModelImpl @Inject constructor(
    private val useCase: ChooseLanguageScreenUseCase,
    private val direction: ChooseLanguageScreenDirection
) : ChooseLanguageScreenViewModel, ViewModel() {

    override fun setLanguage(lang: String) {
        viewModelScope.launch {
            Log.d("DDD", lang)
            useCase.setLanguage(lang)
            direction.openMainScreen()
        }
        viewModelScope.launch {
            useCase.setIsFirst(false)
        }
    }
}