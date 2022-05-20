
package com.example.finalproject
import android.view.View

import android.widget.ImageView

import androidx.databinding.BindingAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.network.Countries
import com.example.finalproject.ui.CountriesApiStatus


import com.example.finalproject.ui.CountriesListAdapter


@BindingAdapter("listData")
/// tut nado posmotret v LIST<TODOLIST>
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Countries>?) {
    val adapter = recyclerView.adapter as CountriesListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: CountriesApiStatus?) {


    when(status) {
        CountriesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CountriesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        CountriesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}



