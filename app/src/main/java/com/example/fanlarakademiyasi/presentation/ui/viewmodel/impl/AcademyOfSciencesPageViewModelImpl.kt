package com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.domain.usecase.AcademyOfSciencesPageUseCase
import com.example.fanlarakademiyasi.presentation.direction.MainScreenDirection
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.AcademyOfSciencesPageViewModel
import com.example.fanlarakademiyasi.presentation.utils.flow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcademyOfSciencesPageViewModelImpl @Inject constructor(
    private val useCase: AcademyOfSciencesPageUseCase,
    private val direction: MainScreenDirection
) : AcademyOfSciencesPageViewModel, ViewModel() {
    override val childCategory = flow<List<ChildCategory>>()

    override val message = flow<String>()

    init {
        viewModelScope.launch {
            useCase.childCategoryRefreshData().collectLatest {
                useCase.childCategoryRefreshData().collectLatest {
                    it.onSuccess {
                        message.emit("Yuklandi")
                    }.onMessage { mes ->
                        message.emit(mes)
                    }.onError { error ->
                        message.emit(error.message.toString())
                    }
                }
            }
        }

        viewModelScope.launch {
            useCase.getChildCategoryByQuery(1).collectLatest {
                childCategory.emit(it)
            }
        }
    }

    override fun onCLickItem(code: Int) {
        viewModelScope.launch {
            when (code) {
                in 3..5 -> {
                    direction.openChildCategory()
                }
                else -> {
                    direction.openDescription()
                }
            }
        }
    }
}