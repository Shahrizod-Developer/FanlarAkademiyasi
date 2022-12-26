package com.example.fanlarakademiyasi.presentation.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow


typealias NavigationArgs = NavController.() -> Unit

interface NavigationHandler {
    val navigationStack: Flow<NavigationArgs>
}