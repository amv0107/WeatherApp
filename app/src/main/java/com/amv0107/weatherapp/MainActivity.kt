package com.amv0107.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amv0107.weatherapp.fragments.MainFragment

const val API_KEY = "63b1b262ab1740eca7e200224221806"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolde, MainFragment.newInstance())
            .commit()
    }
}