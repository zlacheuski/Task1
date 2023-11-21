package com.example.task1.ui.weatheralert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.task1.databinding.ItemWeatherAlertBinding
import com.example.task1.tools.Constants.IMAGE_CORNER_RADIUS
import com.example.task1.tools.Constants.PICTURE_LINK
import com.example.task1.tools.extensions.createCircularProgressBar
import com.example.task1.ui.weatheralert.model.WeatherAlertModel


class WeatherAlertAdapter :
    ListAdapter<WeatherAlertModel, WeatherAlertAdapter.WeatherAlertViewHolder>(diffCallback) {

    private lateinit var itemBinding: ItemWeatherAlertBinding

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
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAlertViewHolder {
        initViewBinding(parent)
        return WeatherAlertViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherAlertViewHolder, position: Int) {
        holder.initViewHolder(getItem(position))
    }

    private fun initViewBinding(parent: ViewGroup) {
        itemBinding =
            ItemWeatherAlertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    inner class WeatherAlertViewHolder(private val itemViewBinding: ItemWeatherAlertBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        fun initViewHolder(
            weatherAlert: WeatherAlertModel
        ) {
            with(itemViewBinding) {
                tvEventMsg.text = weatherAlert.event
                tvStartDateMsg.text = weatherAlert.startDate
                tvEndDateMsg.text = weatherAlert.endDate
                tvDuration.text = weatherAlert.duration
                tvSenderNameMsg.text = weatherAlert.senderName
            }
            showImage(weatherAlert.id)
        }

        private fun showImage(id: String) {
            Glide
                .with(itemViewBinding.root)
                .load(PICTURE_LINK)
                .signature(ObjectKey(id))
                .placeholder(itemBinding.root.context.createCircularProgressBar())
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(IMAGE_CORNER_RADIUS)))
                .into(itemViewBinding.ivPicture)
        }
    }
}