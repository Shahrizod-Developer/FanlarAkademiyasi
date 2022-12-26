package com.example.fanlarakademiyasi.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fanlarakademiyasi.presentation.ui.screen.fragment.main.pages.home.category.*

class MainAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AcademyOfSciencesPage()
            1 -> WorksPage()
            2 -> DocumentsPage()
            3 -> ServicePage()
            4 -> PressServicePage()
            5 -> InternationalRelationsPage()
            6 -> YoungAboutPage()
            else -> AcademyOfSciencesPage()
        }
    }
}