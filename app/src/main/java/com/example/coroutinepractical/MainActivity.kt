package com.example.coroutinepractical

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDummy = findViewById<TextView>(R.id.tvDummy)
        GlobalScope.launch {
            Log.d(TAG,"Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG,"Setting text in thread ${Thread.currentThread().name}")
                tvDummy.text = answer
            }

        }
    }

    suspend fun doNetworkCall() : String {
        delay(3000L)
        return "This is the answer"
    }
    suspend fun doNetworkCall2() : String {
        delay(3000L)
        return "This is the answer"
    }
}