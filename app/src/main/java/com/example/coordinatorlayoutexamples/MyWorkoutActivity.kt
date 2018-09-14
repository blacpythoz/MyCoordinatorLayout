package com.example.coordinatorlayoutexamples

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.view.animation.AlphaAnimation
import com.thesunbi.totalfitness.ui.activity.workout.ExerciseDetailFragment
import kotlinx.android.synthetic.main.activity_main.*


class MyWorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {

        initToolbar()

        var fragment: Fragment = ExerciseDetailFragment()
        var previousSelected = 0

        val fm = supportFragmentManager

        val ft = fm.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> fragment = ExerciseDetailFragment()
                    1 -> fragment = ExerciseDetailFragment()
                    2 -> fragment = ExerciseDetailFragment()
                    3 -> fragment = ExerciseDetailFragment()
                    4 -> fragment = ExerciseDetailFragment()
                }


                val ft = fm.beginTransaction()
                if (previousSelected < tab.position) {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left_exit)
                } else {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right_exit)
                }
                previousSelected = tab.position


                ft.replace(R.id.container, fragment)
                ft.commit()
            }
//
        })
//

    }

    private fun initToolbar() {
        main_toolbar.background.alpha = 0

//        main_toolbar.inflateMenu(R.menu.my_workout_menu)

        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""


        main_appbar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScroll = appBarLayout.totalScrollRange
            val percentage = Math.abs(verticalOffset).toFloat() / maxScroll.toFloat()

            handleAlphaOnTitle(percentage)
            handleToolbarTitleVisibility(percentage)
        }

        startAlphaAnimation(main_textview_title, 0, View.INVISIBLE)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.my_workout_menu, menu)
        return true
    }


    private var PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
    private var PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f
    private var ALPHA_ANIMATIONS_DURATION = 200

    private var mIsTheTitleVisible = false
    private var mIsTheTitleContainerVisible = true

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(main_textview_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
                mIsTheTitleVisible = true
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(main_textview_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
                mIsTheTitleVisible = false
            }
        }
    }

    private fun handleAlphaOnTitle(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(main_linearlayout_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
                mIsTheTitleContainerVisible = false
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(main_linearlayout_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
                mIsTheTitleContainerVisible = true
            }
        }
    }

    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val alphaAnimation = if (visibility == View.VISIBLE)
            AlphaAnimation(0f, 1f)
        else
            AlphaAnimation(1f, 0f)

        alphaAnimation.duration = duration
        alphaAnimation.fillAfter = true
        v.startAnimation(alphaAnimation)
    }

}
