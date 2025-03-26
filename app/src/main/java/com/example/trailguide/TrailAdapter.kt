package com.example.trailguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrailAdapter(private val trails: List<Trail>, private val onItemClick: (Trail) -> Unit) :
    RecyclerView.Adapter<TrailAdapter.TrailViewHolder>() {

    class TrailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewTrail)
        val textView: TextView = itemView.findViewById(R.id.textViewTrailName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trail_item, parent, false)
        return TrailViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
        val trail = trails[position]
        holder.textView.text = trail.name
        holder.imageView.setImageResource(trail.imageResId)
        holder.itemView.setOnClickListener {
            onItemClick(trail)
        }
    }

    override fun getItemCount() = trails.size
}