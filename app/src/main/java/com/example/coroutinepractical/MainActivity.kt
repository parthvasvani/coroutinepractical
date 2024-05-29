package com.example.coroutinepractical

import android.os.Bundle
import android.util.Log
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
import com.example.coroutinepractical.ui.theme.CoroutinePracticalTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"Before runBlocking")
        runBlocking {
            launch {
                delay(3000L)
                Log.d(TAG,"Finished to Coroutine 1")
            }
            launch {
                delay(3000L)
                Log.d(TAG,"Finished to Coroutine 2")
            }
            Log.d(TAG,"Start of runBlocking")
            delay(5000L)
            Log.d(TAG,"End of runBlocking")
        }
        Log.d(TAG,"After runBlocking")
    }
}