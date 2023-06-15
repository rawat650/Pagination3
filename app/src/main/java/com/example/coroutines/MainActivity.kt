package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ApiService
import com.LoadAdapter
import com.PagingAdapter
import com.QuoteFactory
import com.QuoteRepository
import com.QuoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var adapter : PagingAdapter
    lateinit var viewModel:QuoteViewModel
    val apiService = ApiService.getInstance().create(ApiService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val rcView = findViewById<RecyclerView>(R.id.rcview)
        viewModel = ViewModelProvider(this,QuoteFactory(QuoteRepository(apiService))).get(QuoteViewModel::class.java)
        adapter = PagingAdapter()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapter.withLoadStateHeader(
            header = LoadAdapter(),
//            footer = LoadAdapter()
        )
        viewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })




    }
}