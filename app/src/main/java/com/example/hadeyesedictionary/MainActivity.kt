package com.example.hadeyesedictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hadeyesedictionary.Model.HomeData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navHostController: NavController
    lateinit var bottom_nav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostController = findNavController(R.id.nav_controller)
        bottom_nav=findViewById(R.id.bottomview)
        bottom_nav.setupWithNavController(navHostController)

    }

}