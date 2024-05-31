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
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withTimeout

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch {
            /*repeat(5){
                Log.d(TAG, "Coroutine is still continuing...")
                delay(1000L)
            }*/

            Log.d(TAG, "Starting long running calculation...")
            withTimeout(3000L){
                for (i in 30..40){
                    if (isActive){
                        Log.d(TAG, "Result for i = $i: ${fib(i)}")
                    }
                }
            }
            Log.d(TAG, "Ending long running calculation...")
        }
        /*runBlocking {
            //job.join()
            delay(2000L)
            job.cancel()
            Log.d(TAG, "Canceled job !")
            }*/
        }

    fun fib(n: Int): Long{
        return if(n==0) 0
        else if(n==1) 1
        else fib(n-1) + fib(n-2)
    }
}