package com.example.animationapp

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import java.util.concurrent.TimeUnit

class CircularPositioning : AppCompatActivity() {
    private var rootView: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_positioning)

        val moon_image: ImageView = findViewById(R.id.moon_image)
        val moonAnimator = animateMoon(moon_image, TimeUnit.SECONDS.toMillis(2))
        rootView = findViewById(R.id.rootView)

        updateConstraint(R.layout.activity_circular_positioning)
        moonAnimator.start()
    }

    private fun updateConstraint(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(rootView!!)
        TransitionManager.beginDelayedTransition(rootView!!)

    }

    private fun animateMoon(moonImage: ImageView?, orbitDuration: Long): ValueAnimator {

        val anim: ValueAnimator = ValueAnimator.ofInt(0, 359)
        anim.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Int
            val layoutParameters = moonImage?.layoutParams as ConstraintLayout.LayoutParams
            layoutParameters.circleAngle = value.toFloat()
            moonImage.layoutParams = layoutParameters

            anim.duration = orbitDuration
            anim.interpolator = LinearInterpolator()
            anim.repeatMode = ValueAnimator.RESTART
            anim.repeatCount = ValueAnimator.INFINITE
        }
     return anim
    }
}