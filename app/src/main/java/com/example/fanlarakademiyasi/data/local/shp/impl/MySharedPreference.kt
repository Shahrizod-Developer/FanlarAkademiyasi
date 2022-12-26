package com.example.fanlarakademiyasi.data.local.shp.impl

import android.content.Context
import android.content.SharedPreferences
import com.example.fanlarakademiyasi.data.local.shp.SharedPreference
import javax.inject.Inject


class MySharedPreference @Inject constructor(
    context: Context, sharedPreference: SharedPreferences
) : SharedPreference(context, sharedPreference) {


    var isFirst: Boolean by Booleans(true)

    var isFirstIntro: Boolean by Booleans(true)

    var language: String by Strings("uz")
}