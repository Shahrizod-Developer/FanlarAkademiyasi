package com.example.fanlarakademiyasi.presentation.ui.screen.fragment.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fanlarakademiyasi.R
import com.example.fanlarakademiyasi.databinding.ScreenMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {

    private val binding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navView = binding.bottomNavBar
        val navController =
            requireActivity().findNavController(R.id.fragment)
        navView.setupWithNavController(navController)
    }
}