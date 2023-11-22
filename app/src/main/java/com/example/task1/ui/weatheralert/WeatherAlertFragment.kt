package com.example.task1.ui.weatheralert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.task1.databinding.FragmentWeatherAlertBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherAlertFragment : Fragment() {

    private lateinit var binding: FragmentWeatherAlertBinding
    private lateinit var adapter: WeatherAlertAdapter
    private val viewModel: WeatherAlertViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherAlertBinding.inflate(layoutInflater)
        initRecyclerView()
        collectEvent()
        return binding.root
    }

    private fun collectEvent() {
        lifecycleScope.launch {
            viewModel.weatherAlertList.collect {
                adapter.submitList(it)
            }
        }
        lifecycleScope.launch {
            viewModel.isProgressVisible.collect {
                binding.progress.isVisible = it
            }
        }
    }

    private fun initRecyclerView() {
        adapter = WeatherAlertAdapter()
        binding.rvAlerts.adapter = adapter
    }
}