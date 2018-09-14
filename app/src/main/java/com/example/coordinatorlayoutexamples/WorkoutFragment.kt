package com.thesunbi.totalfitness.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coordinatorlayoutexamples.R
import kotlinx.android.synthetic.main.layout_recyclerview.view.*

class WorkoutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_recyclerview, container, false)

        view.rvLayout.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = WorkoutAdapter()
        }

        return view
    }


    inner class WorkoutAdapter : RecyclerView.Adapter<WorkoutAdapter.VH>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_workout, parent, false)
            return VH(view)
        }

        override fun getItemCount(): Int {
            return 9
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.bind()
        }


        inner class VH(var view: View) : RecyclerView.ViewHolder(view) {
            fun bind() {
                with(view) {
                    //todo
                }
            }
        }
    }
}