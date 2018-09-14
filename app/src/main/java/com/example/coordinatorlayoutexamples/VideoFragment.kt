package com.thesunbi.totalfitness.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_recyclerview.view.*
import android.view.ViewGroup.MarginLayoutParams
import kotlinx.android.synthetic.main.item_workout_videos.view.*
import android.util.TypedValue
import com.example.coordinatorlayoutexamples.R


class VideoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_recyclerview, container, false)
        view.rvLayout.layoutManager = LinearLayoutManager(activity)
        view.rvLayout.adapter = VideoAdapter()
        return view
    }

    inner class VideoAdapter : RecyclerView.Adapter<VideoAdapter.VH>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_videos, parent, false)
            return VH(view)
        }

        override fun getItemCount(): Int {
            return 2
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            if (position == 20) {
                val marginParams = holder.view.cvItemWorkout.layoutParams as (MarginLayoutParams)
                val dm = holder.view.resources.displayMetrics
                val pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64f, dm)
                marginParams.bottomMargin = Math.round(pixels)

            }
        }


        inner class VH(var view: View) : RecyclerView.ViewHolder(view) {}

    }
}