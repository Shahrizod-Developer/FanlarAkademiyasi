package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.domain.usecase.MainActivityUseCase
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.MainActivityViewModel
import com.example.fanlarakademiyasi.presentation.utils.flow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModelImpl @Inject constructor(
    private val useCase: MainActivityUseCase
) : MainActivityViewModel, ViewModel() {
    override val languageFlow = flow<String>()

    init {
        viewModelScope.launch {
            useCase.getLanguage().collectLatest {
                languageFlow.emit(it)
            }
        }
    }
}