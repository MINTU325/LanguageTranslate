package com.example.languagetranslate

import android.app.LocaleManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.languagetranslate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnHindi.setOnClickListener {
            LocaleHelper.setLocale(this, "hi")
        }

        binding.btnJapan.setOnClickListener {
            LocaleHelper.setLocale(this, "ja")


        }

        binding.btnSanskrit.setOnClickListener {
            LocaleHelper.setLocale(this, "sa")

        }

        Log.d("SDK_VERSION", "Current  locale default = "+this.resources.configuration.locales[0].language )



    }

}