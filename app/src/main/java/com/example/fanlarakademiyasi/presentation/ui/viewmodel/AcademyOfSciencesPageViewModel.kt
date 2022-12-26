package com.example.fanlarakademiyasi.presentation.ui.viewmodel

import com.example.fanlarakademiyasi.data.model.ChildCategory
import kotlinx.coroutines.flow.Flow

interface AcademyOfSciencesPageViewModel {

    val childCategory: Flow<List<ChildCategory>>

    val message: Flow<String>

    fun onCLickItem(code: Int)
}