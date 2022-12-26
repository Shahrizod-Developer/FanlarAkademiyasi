package com.example.fanlarakademiyasi.presentation.ui.screen.fragment.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fanlarakademiyasi.R
import com.example.fanlarakademiyasi.domain.usecase.SplashScreenUseCase
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.SplashScreenViewModel
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl.SplashScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val viewModel: SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.navigate()
    }
}