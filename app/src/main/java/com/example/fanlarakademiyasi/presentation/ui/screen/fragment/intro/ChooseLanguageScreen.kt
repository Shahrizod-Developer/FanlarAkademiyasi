package com.example.fanlarakademiyasi.presentation.ui.screen.fragment.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fanlarakademiyasi.R
import com.example.fanlarakademiyasi.databinding.ScreenChooseLanguageBinding
import com.example.fanlarakademiyasi.presentation.ui.screen.activity.MainActivity
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.ChooseLanguageScreenViewModel
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.MainActivityViewModel
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl.ChooseLanguageScreenViewModelImpl
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl.MainActivityViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseLanguageScreen : Fragment(R.layout.screen_choose_language) {

    private val binding: ScreenChooseLanguageBinding by viewBinding(ScreenChooseLanguageBinding::bind)
    private val viewModel: ChooseLanguageScreenViewModel by viewModels<ChooseLanguageScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.english.setOnClickListener {
            viewModel.setLanguage("eng")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        binding.russian.setOnClickListener {
            viewModel.setLanguage("ru")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        binding.uzbek.setOnClickListener {
            viewModel.setLanguage("uz")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }
}