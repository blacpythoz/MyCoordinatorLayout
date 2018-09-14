package com.thesunbi.totalfitness.ui.activity.workout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coordinatorlayoutexamples.CustomFragmentAdapter
import com.example.coordinatorlayoutexamples.R
import com.thesunbi.totalfitness.ui.fragment.VideoFragment
import com.thesunbi.totalfitness.ui.fragment.WorkoutFragment
import kotlinx.android.synthetic.main.fragment_exercise_detail.view.*

class ExerciseDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_exercise_detail, container, false)
        val adapter = CustomFragmentAdapter(activity?.supportFragmentManager)
        adapter.addFragment(VideoFragment(), "VIDEOS")
        adapter.addFragment(WorkoutFragment(), "WORKOUT")

        v.vpCategory.adapter = adapter
        v.tlCategory.setupWithViewPager(v.vpCategory)

//
//        var fragment: Fragment = VideoFragment()
//        var previousSelected = 0
//        v.tlCategory.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {}
//
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                when (tab.position) {
//                    0 -> fragment = VideoFragment()
//                    1 -> fragment = WorkoutFragment()
//                }
//
//                val fm = activity!!.supportFragmentManager
//                val ft = fm.beginTransaction()
//                if (previousSelected < tab.position) {
//                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left_exit)
//                } else {
//                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right_exit)
//                }
//                previousSelected = tab.position
//                ft.replace(R.id.vpCategory, fragment)
//                ft.commit()
//            }
//
//        })
//
//
//        val fm = activity!!.supportFragmentManager
//        val ft = fm.beginTransaction()
//        ft.replace(R.id.vpCategory, fragment)
//        ft.commit()

        return v

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ExerciseDetailFragment::class.java))
        }
    }
}