package org.journey.tridy_android

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import org.journey.tridy_android.databinding.ActivityEntryBinding
@AndroidEntryPoint
class EntryActivity: AppCompatActivity(){
    private lateinit var binding: ActivityEntryBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = (supportFragmentManager.findFragmentById(R.id.fragment_nav_host_entry) as NavHostFragment).navController

    }
}