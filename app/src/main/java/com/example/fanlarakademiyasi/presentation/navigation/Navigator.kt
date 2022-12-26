package com.example.fanlarakademiyasi.presentation.navigation

import androidx.navigation.NavDirections

typealias Direction = NavDirections

interface Navigator {
    suspend fun navigateTo(directions: Direction)
}