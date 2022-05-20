
package com.example.finalproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView



import com.example.finalproject.databinding.ListViewItemBinding
import com.example.finalproject.network.Countries



class CountriesListAdapter(private val clickListener: CountriesListener) :

    ListAdapter<Countries, CountriesListAdapter.CountriesViewHolder>(DiffCallback) {

    class CountriesViewHolder(
        var binding: ListViewItemBinding
        ) : RecyclerView.ViewHolder(binding.root){
        // zdes todos: Todos
        fun bind(clickListener: CountriesListener, countries: Countries) {
            //todos
            binding.countries = countries
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Countries>() {

        override fun areItemsTheSame(oldItem: Countries, newItem: Countries): Boolean {
            return oldItem.Country == newItem.Country
        }

        override fun areContentsTheSame(oldItem: Countries, newItem: Countries): Boolean {
            return oldItem.Country == newItem.Country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountriesViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val countries = getItem(position)
        holder.bind(clickListener, countries)
    }
}

class CountriesListener(val clickListener: (countries: Countries) -> Unit) {
    fun onClick(countries: Countries) = clickListener(countries)
}
