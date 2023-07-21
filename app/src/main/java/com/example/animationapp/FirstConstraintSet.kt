package com.example.animationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class FirstConstraintSet : AppCompatActivity() {

    private val constraintSetNormal=ConstraintSet()
    private val constraintSetBig=ConstraintSet()
    private var rootlayout:ConstraintLayout?= null
    private var showBigImage:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_constraint_set)

        rootlayout=findViewById(R.id.start_animation_constaintLayout)
        constraintSetNormal.clone(rootlayout!!)
        constraintSetBig.load(this,R.layout.first_constraint_set_end)
    }

    fun toggledMode(view: View) {
        TransitionManager.beginDelayedTransition(rootlayout!!)
        showBigImage=!showBigImage
        applyConfig()
    }

    private fun applyConfig() {
       if(showBigImage==true)
           constraintSetBig.applyTo(rootlayout!!)
        else
            constraintSetNormal.applyTo(rootlayout!!)
    }
}