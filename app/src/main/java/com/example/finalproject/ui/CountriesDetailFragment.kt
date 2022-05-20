
package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.finalproject.databinding.FragmentCountriesDetailBinding
import com.example.finalproject.ui.CountriesViewModel



class CountriesDetailFragment : Fragment() {
    //niche ne menyaem voobshe zdes
    private val viewModel: CountriesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCountriesDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }
}
