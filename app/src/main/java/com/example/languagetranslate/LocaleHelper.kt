package com.example.languagetranslate

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*
import android.os.LocaleList
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.getSystemService
import androidx.core.os.LocaleListCompat
import java.util.*

object LocaleHelper {
    fun setLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val configuration = Configuration(context.resources.configuration)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Log.d("SDK_VERSION","if sdk version "+Build.VERSION.SDK_INT .toString() )
            context.getSystemService(LocaleManager::class.java)
                .applicationLocales = LocaleList.forLanguageTags(language)
        } else {
            Log.d("SDK_VERSION","else sdk version "+Build.VERSION.SDK_INT .toString() )
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language))
        }


    }

    // Function to get the saved locale
    fun getLocale(context: Context): Locale {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            return context.getSystemService(LocaleManager::class.java).applicationLocales[0]

            Log.d("SDK_VERSION", "Current Locale TIRAMISU= "+LocaleHelper.getLocale(context) )


        }else{
            Log.d("SDK_VERSION", "Current Locale else= "+LocaleHelper.getLocale(context) )

            return AppCompatDelegate.getApplicationLocales().get(0)!!

        }

        Log.d("SDK_VERSION", "Current  locale default = "+context.resources.configuration.locales[0].displayScript )

//        return context.resources.configuration.locales[0]
    }
}
