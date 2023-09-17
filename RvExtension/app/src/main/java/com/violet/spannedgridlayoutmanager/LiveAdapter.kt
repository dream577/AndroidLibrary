package com.violet.spannedgridlayoutmanager

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.violet.spannedgridlayoutmanager.extension.SpannableGridLayoutManager
import java.util.Collections

class LiveAdapter() : RecyclerView.Adapter<LiveAdapter.ViewHolder>() {
    private val sourceList = mutableListOf<String>()

    fun setData(list: List<String>) {
        sourceList.clear()
        sourceList.addAll(list)
        notifyDataSetChanged()
    }

    fun exchange(source: Int, target: Int) {
        Collections.swap(sourceList, source, target)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_live, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = sourceList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = sourceList[position]
        val itemView = holder.itemView
        val lp = itemView.layoutParams as SpannableGridLayoutManager.LayoutParams
        if (position % 6 == 0) {
            lp.rowSpan = 2
            lp.colSpan = 2
            itemView.layoutParams = lp
        } else {
            lp.rowSpan = 1
            lp.colSpan = 1
            itemView.layoutParams = lp
        }
        itemView.setOnClickListener {
            Log.d("LiveAdapter", "position: $position")
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_name)
        }
    }
}