package com.littlelemon.littlelemon

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val sharedPreferences = getSharedPreferences("LittleLemon", MODE_PRIVATE)

            MyNavigation(builder, sharedPreferences)
        }
    }
}


@Composable
fun MyNavigation(builder: AlertDialog.Builder, sharedPreferences: SharedPreferences) {
    val navController  = rememberNavController()
    Navigation(navController, builder, sharedPreferences)
}