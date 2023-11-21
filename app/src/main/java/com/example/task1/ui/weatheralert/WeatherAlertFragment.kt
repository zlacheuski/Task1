package com.example.task1.ui.weatheralert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.data.repository.Resource
import com.example.task1.databinding.FragmentWeatherAlertBinding
import com.example.task1.tools.cache.MemoryCacheImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class WeatherAlertFragment : Fragment() {

    private lateinit var binding: FragmentWeatherAlertBinding
    private lateinit var adapter: WeatherAlertAdapter
    private val viewModel: WeatherAlertViewModel by viewModels()

    @Inject
    lateinit var imageCache: MemoryCacheImpl
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViewBinding()
        initRecyclerView()
        collectEvent()
        return binding.root
    }

    private fun collectEvent() {
        lifecycleScope.launch {
            viewModel.response.collect {
                with(binding) {
                    when (it) {
                        is Resource.Success -> {
                            progress.isVisible = false
                            errorLayout.root.isVisible = false
                            adapter.submitList(viewModel.getMappedAlertsList(it.data).weatherAlertList)
                        }
                        is Resource.Progress -> {
                            progress.isVisible = true
                            errorLayout.root.isVisible = false
                        }
                        is Resource.Error -> {
                            progress.isVisible = false
                            errorLayout.root.isVisible = true
                        }
                        is Resource.Empty -> {
                            progress.isVisible = false
                            errorLayout.root.isVisible = true
                        }
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = WeatherAlertAdapter()
        val llm = LinearLayoutManager(activity?.baseContext)
        llm.orientation = RecyclerView.VERTICAL
        with(binding) {
            rvAlerts.adapter = adapter
            rvAlerts.layoutManager = llm
        }
    }

    private fun initViewBinding() {
        binding = FragmentWeatherAlertBinding.inflate(layoutInflater)
    }
}