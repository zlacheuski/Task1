package com.example.task1.ui.weatheralert

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.data.repository.Resource
import com.example.task1.databinding.FragmentWeatherAlertBinding
import com.example.task1.tools.extensions.hide
import com.example.task1.tools.extensions.show
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
                            progress.hide()
                            errorLayout.root.hide()
                            adapter.addData(viewModel.getMappedAlertsList(it.data).weatherAlertList)
                        }
                        is Resource.Progress -> {
                            progress.show()
                            errorLayout.root.hide()
                        }
                        is Resource.Error -> {
                            progress.hide()
                            errorLayout.root.show()
                        }
                        is Resource.Empty -> {
                            progress.hide()
                            errorLayout.root.show()
                            Log.d("****", it.status)
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