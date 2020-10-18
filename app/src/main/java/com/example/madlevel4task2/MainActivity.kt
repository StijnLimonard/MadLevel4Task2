package com.example.madlevel4task2

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import java.io.Console

class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.gameFragment)) {
                menu.findItem(R.id.btnGameHistory).isVisible = true
                menu.findItem(R.id.btnDeleteAllGames).isVisible = false
                supportActionBar?.title = "Mad Level 4 Task 2"
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
            } else {
                menu.findItem(R.id.btnGameHistory).isVisible = false
                menu.findItem(R.id.btnDeleteAllGames).isVisible = true
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
                supportActionBar?.title = "Your Game History"
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(item.toString(), "test")
        return when (item.itemId) {
            R.id.btnGameHistory -> {
                navController.navigate(R.id.action_gameFragment_to_historyFragment)
                true
            }
            //dit nummer is het id van de back icon.
            16908332  -> {
                navController.navigate(R.id.action_gameFragment_to_historyFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}