package com.example.coroutinepractical

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.coroutinepractical.ui.theme.CoroutinePracticalTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartActivity = findViewById<Button>(R.id.btnStartActivity)
        btnStartActivity.setOnClickListener {
            lifecycleScope.launch {
                while (true){
                    delay(1000L)
                    Log.d(TAG,"Still running...")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity,SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}