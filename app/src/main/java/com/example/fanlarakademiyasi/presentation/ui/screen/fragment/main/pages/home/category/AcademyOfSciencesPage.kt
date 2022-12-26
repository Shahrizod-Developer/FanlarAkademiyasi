package com.example.fanlarakademiyasi.presentation.ui.screen.fragment.main.pages.home.category

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fanlarakademiyasi.R
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.databinding.PageAcademyOfSciencesBinding
import com.example.fanlarakademiyasi.presentation.adapter.ChildCategoryAdepter
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.AcademyOfSciencesPageViewModel
import com.example.fanlarakademiyasi.presentation.ui.viewmodel.impl.AcademyOfSciencesPageViewModelImpl
import com.example.fanlarakademiyasi.presentation.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AcademyOfSciencesPage : Fragment(R.layout.page_academy_of_sciences) {

    private val binding: PageAcademyOfSciencesBinding by viewBinding(PageAcademyOfSciencesBinding::class.java)
    private val viewModel: AcademyOfSciencesPageViewModel by viewModels<AcademyOfSciencesPageViewModelImpl>()
    private val adapter: ChildCategoryAdepter by lazy { ChildCategoryAdepter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.onClickItem {
            viewModel.onCLickItem(it.code)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.message.collectLatest {
                toast(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.childCategory.collectLatest {
                Log.d("TTT", it.size.toString())
                adapter.submitList(it)
            }
        }

        binding.rv.adapter = adapter
    }
}