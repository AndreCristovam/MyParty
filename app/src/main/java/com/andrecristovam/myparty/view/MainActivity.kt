package com.andrecristovam.myparty.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.andrecristovam.myparty.R
import com.andrecristovam.myparty.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        // Btn Add novo convidado
        binding.appBarMain.fab.setOnClickListener{
            val intent = Intent(this@MainActivity, GuestFormActivity::class.java)
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)

        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_all, R.id.nav_presents, R.id.nav_absents
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, mAppBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }
}