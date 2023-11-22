package com.example.task1.ui.weatheralert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.databinding.ItemWeatherAlertBinding
import com.example.task1.domain.model.WeatherAlertModel


class WeatherAlertAdapter(val onBindWithoutImage: (WeatherAlertModel) -> Unit) :
    ListAdapter<WeatherAlertModel, WeatherAlertAdapter.WeatherAlertViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<WeatherAlertModel>() {

            override fun areItemsTheSame(
                oldItem: WeatherAlertModel,
                newItem: WeatherAlertModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: WeatherAlertModel,
                newItem: WeatherAlertModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAlertViewHolder {
        val itemBinding =
            ItemWeatherAlertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherAlertViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherAlertViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class WeatherAlertViewHolder(private val itemViewBinding: ItemWeatherAlertBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bind(
            weatherAlert: WeatherAlertModel
        ) {
            with(itemViewBinding) {
                tvEventMsg.text = weatherAlert.event
                tvStartDateMsg.text = weatherAlert.startDate
                tvEndDateMsg.text = weatherAlert.endDate
                tvDuration.text = weatherAlert.duration
                tvSenderNameMsg.text = weatherAlert.senderName
                // This is caching method
                if (weatherAlert.image == null) {
                    onBindWithoutImage(weatherAlert)
                } else {
                    ivPicture.setImageBitmap(weatherAlert.image)
                }
            }
        }
    }
}