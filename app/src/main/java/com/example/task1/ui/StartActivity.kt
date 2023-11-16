package com.example.task1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.databinding.ActivityStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setContentView(binding.root)
    }

    private fun initViewBinding() {
        binding = ActivityStartBinding.inflate(layoutInflater)
    }
}