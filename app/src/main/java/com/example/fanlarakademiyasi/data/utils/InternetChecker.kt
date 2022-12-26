package com.example.fanlarakademiyasi.data.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.fanlarakademiyasi.app.App
import java.lang.RuntimeException

@RequiresApi(Build.VERSION_CODES.M)
fun hasConnection(): Boolean = App.instance.hasConnection()

@RequiresApi(Build.VERSION_CODES.M)
fun Context.hasConnection(): Boolean {
    val result: Boolean
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities =
        connectivityManager.activeNetwork ?: return false
    val actNw =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    result = when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result
}

class NoInternetConnection : RuntimeException("No internet connection")