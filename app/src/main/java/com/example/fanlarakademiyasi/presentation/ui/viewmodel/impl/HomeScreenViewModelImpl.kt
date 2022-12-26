package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.domain.usecase.HomeScreenUseCase
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.HomeScreenViewModel
import com.example.fanlarakademiyasi.presentation.utils.flow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModelImpl @Inject constructor(
    private val useCase: HomeScreenUseCase
) : ViewModel(), HomeScreenViewModel {
    override val categoryList = flow<List<Category>>()
    override val message = flow<String>()

    init {
        viewModelScope.launch {
            useCase.refreshCategoryData().collectLatest {
                it.onSuccess {
                    message.emit("Yuklandi")
                }.onMessage { mes ->
                    message.emit(mes)
                }.onError { error ->
                    message.emit(error.message.toString())
                }
            }
        }
        viewModelScope.launch {
            useCase.getAllCategory().collectLatest {
                categoryList.emit(it)
            }
        }
    }
}