package com.opensource.armnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.opensource.armnews.databinding.ActivityMainBinding
import com.opensource.armnews.presentation.viewmodel.NewsViewModel
import com.opensource.armnews.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    internal lateinit var newsViewModel: NewsViewModel
    internal lateinit var newsViewModelFactory: NewsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpHostFragment()
        setUpViewModel()
    }

    private fun setUpHostFragment() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun setUpViewModel() {
        newsViewModel = ViewModelProvider(this, newsViewModelFactory)[NewsViewModel::class.java]
    }
}