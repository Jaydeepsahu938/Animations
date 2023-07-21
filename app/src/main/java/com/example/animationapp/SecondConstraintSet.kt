package com.example.animationapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class SecondConstraintSet : AppCompatActivity() {
    private val constraintSetNormal= ConstraintSet()
    private val constraintSetBig= ConstraintSet()
    private var rootlayout: ConstraintLayout?= null
    private var showBigImage:Boolean=false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_constraint_set)

        rootlayout=findViewById(R.id.start_constraintset)
        constraintSetNormal.clone(rootlayout!!)
        constraintSetBig.load(this,R.layout.second_constraint_set_end)
    }
    fun toggledMode(view: View) {
        val transition=ChangeBounds()
        transition.interpolator=AnticipateInterpolator(3.0f)
        transition.duration=1200
        TransitionManager.beginDelayedTransition(rootlayout!!,transition)
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