package com.example.fanlarakademiyasi.presentation.ui.screen.fragment.main.pages.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fanlarakademiyasi.R
import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.databinding.ScreenHomeBinding
import com.example.fanlarakademiyasi.presentation.adapter.MainAdapter
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.HomeScreenViewModel
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl.HomeScreenViewModelImpl
import com.example.fanlarakademiyasi.presentation.utils.toast
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomePage : Fragment(R.layout.screen_home) {

    private val binding: ScreenHomeBinding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeScreenViewModel by viewModels<HomeScreenViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = arrayListOf(
            resources.getString(R.string.academy_of_science),
            resources.getString(R.string.works),
            resources.getString(R.string.documents),
            resources.getString(R.string.services),
            resources.getString(R.string.press_service),
            resources.getString(R.string.international_relations),
            resources.getString(R.string.youth_issues),
        )
        binding.viewPager.adapter = MainAdapter(requireActivity())

        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            tab.text = list[position]
        }.attach()


    }
}