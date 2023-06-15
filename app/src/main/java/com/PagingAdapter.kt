package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingConfig
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines.R

class PagingAdapter : PagingDataAdapter<Result, PagingAdapter.QuoteViewHolder>(COMPARATOR) {

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.txtView.setText(item.content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.quote_item, parent, false
        )
        return QuoteViewHolder(view)
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtView = itemView.findViewById<TextView>(
            R.id.txtview
        )
    }

    private companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }


            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.content == newItem.content
            }

        }
    }


}
