package com.example.fanlarakademiyasi.presentation.direction.impl

import com.example.fanlarakademiyasi.presentation.direction.MainScreenDirection
import com.example.fanlarakademiyasi.presentation.navigation.Navigator
import com.example.fanlarakademiyasi.presentation.ui.screen.fragment.main.MainScreenDirections
import javax.inject.Inject

class MainScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : MainScreenDirection {
    override suspend fun openDescription() {
        navigator.navigateTo(MainScreenDirections.actionMainScreenToDescriptionScreen())
    }

    override suspend fun openChildCategory() {
        navigator.navigateTo(MainScreenDirections.actionMainScreenToChildCategoryScreen())
    }

}