package com.example.task1.ui.weatheralert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.data.model.weatheralert.WeatherAlert
import com.example.task1.databinding.ItemWeatherAlertBinding
import com.example.task1.ui.weatheralert.model.WeatherAlertModel

class WeatherAlertAdapter :
    ListAdapter<WeatherAlert, WeatherAlertAdapter.WeatherAlertViewHolder>(diffCallback) {

    lateinit var itemBinding: ItemWeatherAlertBinding
    private val weatherAlertList: MutableList<WeatherAlertModel> = mutableListOf()

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<WeatherAlert>() {

            override fun areItemsTheSame(oldItem: WeatherAlert, newItem: WeatherAlert): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: WeatherAlert, newItem: WeatherAlert): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAlertViewHolder {
        initViewBinding(parent)
        return WeatherAlertViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherAlertViewHolder, position: Int) {
        holder.initViewHolder(weatherAlertList[position])
    }

    override fun getItemCount() = weatherAlertList.size


    fun addData(weatherAlertList: List<WeatherAlertModel>) {
        this.weatherAlertList.apply {
            clear()
            addAll(weatherAlertList)
        }
        notifyDataSetChanged()
    }

    private fun initViewBinding(parent: ViewGroup) {
        itemBinding =
            ItemWeatherAlertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    inner class WeatherAlertViewHolder(val itemViewBinding: ItemWeatherAlertBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun initViewHolder(
            weatherAlert: WeatherAlertModel
        ) {
            with(itemViewBinding) {
                tvEventMsg.text = weatherAlert.event
                tvStartDateMsg.text = weatherAlert.effective
                tvEndDateMsg.text = weatherAlert.ends
                tvSenderNameMsg.text = weatherAlert.senderName
            }
        }
    }
}