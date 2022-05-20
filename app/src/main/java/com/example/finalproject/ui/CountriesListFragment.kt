
package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentTCountriesListBinding



class CountriesListFragment : Fragment() {

    private val viewModel: CountriesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCountriesListBinding.inflate(inflater)
        viewModel.getCountries()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CountriesListAdapter(CountriesListener { countries ->
            viewModel.onCountriesClicked(countries)
            findNavController()
                .navigate(R.id.action_CountriesListFragment_to_CountriesDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}
