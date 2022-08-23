package com.example.garage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.garage.R
import com.example.garage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.menuFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    navController.navigate(R.id.menuFragment)
                    true
                }
                R.id.busket -> {
                    navController.navigate(R.id.busketFragment)
                    true
                }
                R.id.profile -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    navController.navigate(R.id.menuFragment)
                }
                R.id.busket -> {
                    navController.navigate(R.id.busketFragment)
                }
                R.id.profile -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
        }
    }
}