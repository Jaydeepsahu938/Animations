package com.example.animationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun constraintSetFirstExample(view: View) {
        startActivity(Intent(this,FirstConstraintSet::class.java))
    }
    fun constraintSetSecondExample(view: View) {
        startActivity(Intent(this,SecondConstraintSet::class.java))
    }
    fun placeHolderExample(view: View) {
        startActivity(Intent(this,PlaceHolderActivity::class.java))
    }
    fun circlePositioning(view: View) {
        startActivity(Intent(this,CircularPositioning::class.java))
    }
}