package com.example.drizzle.grappus_assignment;

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.animation.AnimationUtils
import com.facebook.rebound.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private companion object {
        private val TENSION = 40.0
        private val FRICTION = 6.0
        private val START_SCALE = 0.0
        private val END_SCALE = 1.0

        private val START_LOGO_ANIM: Long = 500
        private val START_HEADING_ANIM: Long = 2000
        private val START_BUTTON_ANIM: Long = 2500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tv_term_cond.text = Html.fromHtml(String.format(getString(R.string.by_using_this_service_i_accept_athleteminder_s_term_of_service)))

        btn_skip.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        Handler().postDelayed({
            animateLogoRebound()
        }, START_LOGO_ANIM)

        Handler().postDelayed({
            animateHeadingAndSubHeading()
        }, START_HEADING_ANIM)

        Handler().postDelayed({
            animateButton()
        }, START_BUTTON_ANIM)
    }

    private fun animateLogoRebound() {
        val springSystem = SpringSystem.create()
        val spring = springSystem.createSpring()
        spring.springConfig = SpringConfig(TENSION, FRICTION)
        spring.endValue = 1.0

        spring.addListener(object : SimpleSpringListener() {

            override fun onSpringUpdate(spring: Spring) {
                // You can observe the updates in the spring
                // state by asking its current value in onSpringUpdate.
                val value = spring.currentValue.toFloat()
                val mappedValue = SpringUtil.mapValueFromRangeToRange(
                        spring.currentValue, 0.0, 1.0, START_SCALE, END_SCALE).toFloat()
                val scale = 1f - value * 0.5f
                iv_logo.scaleX = mappedValue
                iv_logo.scaleY = mappedValue
            }

            override fun onSpringAtRest(spring: Spring) {

            }

            override fun onSpringActivate(spring: Spring) {

            }

            override fun onSpringEndStateChange(spring: Spring) {

            }
        })
    }

    private fun animateHeadingAndSubHeading() {
        val animationFadeIn = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in)
        animationFadeIn.fillAfter = true
        tv_head_text.startAnimation(animationFadeIn)
        tv_sub_heading_text.startAnimation(animationFadeIn)
    }

    private fun animateButton() {
        val animationFadeIn = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in)
        animationFadeIn.fillAfter = true
        btn_create_profile.startAnimation(animationFadeIn)

        Handler().postDelayed({
            val animationFadeInInner = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in)
            animationFadeInInner.fillAfter = true
            btn_skip.startAnimation(animationFadeInInner)
            tv_term_cond.startAnimation(animationFadeInInner)
            indicator.startAnimation(animationFadeInInner)
        }, 250)

    }
}
