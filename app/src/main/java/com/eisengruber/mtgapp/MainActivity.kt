package com.eisengruber.mtgapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame_layout, SearchFragment())
            .commit()
    }
}
