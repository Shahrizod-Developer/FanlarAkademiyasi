package com.example.fanlarakademiyasi.presentation.ui.viewmodel

import com.example.fanlarakademiyasi.data.model.Category
import kotlinx.coroutines.flow.Flow

interface HomeScreenViewModel {

    val categoryList: Flow<List<Category>>

    val message: Flow<String>
}