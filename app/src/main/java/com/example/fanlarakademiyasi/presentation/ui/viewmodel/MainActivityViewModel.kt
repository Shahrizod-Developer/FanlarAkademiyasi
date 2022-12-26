package com.example.fanlarakademiyasi.presentation.ui.viewmodel

import kotlinx.coroutines.flow.Flow

interface MainActivityViewModel {

    val languageFlow: Flow<String>
}