package com.example.trailguide

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashIcon: ImageView = findViewById(R.id.splashIcon)
        val splashText: TextView = findViewById(R.id.splashText)


        val scaleX = ObjectAnimator.ofFloat(splashIcon, "scaleX", 0.5f, 1f)
        val scaleY = ObjectAnimator.ofFloat(splashIcon, "scaleY", 0.5f, 1f)


        val translateY = ObjectAnimator.ofFloat(splashText, "translationY", 100f, 0f)


        scaleX.duration = 2000
        scaleY.duration = 2000
        translateY.duration = 2000


        scaleX.interpolator = AccelerateDecelerateInterpolator()
        scaleY.interpolator = AccelerateDecelerateInterpolator()
        translateY.interpolator = AccelerateDecelerateInterpolator()


        scaleX.start()
        scaleY.start()
        translateY.start()


        splashText.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}
