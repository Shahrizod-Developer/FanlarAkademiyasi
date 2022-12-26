package com.example.fanlarakademiyasi.presentation.ui.viewmodel

import com.example.fanlarakademiyasi.data.model.IntroData
import kotlinx.coroutines.flow.Flow

interface IntroScreenViewModel {

    val introDataList: Flow<List<IntroData>>

    val currentItemFlow: Flow<Int>

    fun onClickSkip()

    fun onClickNext(currentItem: Int)
}