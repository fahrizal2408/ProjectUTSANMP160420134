package com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.view

import android.content.Context
import android.content.SharedPreferences
import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.appsolution.a160420134_fahrizalwijanarkoamroe_projectanmp_healthcareumc.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var localStorage: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navController=(supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment).navController


        val Hamburger = AppBarConfiguration(setOf(R.id.itemHome,R.id.itemProfile,R.id.itemDoctor),drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController,Hamburger)
        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navView, navController)

        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
        this.supportActionBar?.hide()

//        Bottom
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{ _ , d, _ ->
            Log.d("Current Frag: ",d.id.toString())

            if(d.label=="Login"){
                bottomNav.visibility= View.GONE
                drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
                this.supportActionBar?.hide()

            }
            else {
                bottomNav.visibility= View.VISIBLE
                drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
                this.supportActionBar?.show()
                actionBar?.setDisplayShowHomeEnabled(false)
                actionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
        }
    override fun onSupportNavigateUp(): Boolean {

        if(navController.currentDestination?.label.toString()=="Home" || navController.currentDestination?.label.toString()=="Profile" || navController.currentDestination?.label.toString()=="Doctor"){
            drawerLayout.openDrawer(findViewById(R.id.navView),true)
            return  super.onSupportNavigateUp()
        }
        else{
            return NavigationUI.navigateUp(navController, drawerLayout)
        }

    }
}
