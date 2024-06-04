package com.example.coroutinepractical

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

data class Person(
    val name: String = "",
    val age: Int = -1
)
class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
        val tutorialDocument = Firebase.firestore.collection("coroutines")
            .document("tutorial")
        val peter = Person("Peter", 25)
        GlobalScope.launch(Dispatchers.IO) {
            tutorialDocument.set(peter).await()
            val person = tutorialDocument.get().await().toObject(Person::class.java)
            withContext(Dispatchers.Main){
                val tvData = findViewById<TextView>(R.id.tvData)
                tvData.text = person.toString()
            }
        }
    }
}