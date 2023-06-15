package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines.R

class LoadAdapter:LoadStateAdapter<LoadAdapter.LoadViewHoler>() {
    class LoadViewHoler(itemView: View) :RecyclerView.ViewHolder(itemView){
        val loader = itemView.findViewById<ProgressBar>(R.id.loader)
        fun bind(loadState: LoadState){
            loader.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoadViewHoler, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.load_item,parent,false)
        return LoadViewHoler(view)

    }
}