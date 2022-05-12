package com.brandonkitt.alarms.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brandonkitt.alarms.databinding.ItemListingBinding
import com.brandonkitt.alarms.entities.AlarmEntity
import com.brandonkitt.alarms.enums.toShortString
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class ListingAdapter : RecyclerView.Adapter<ListingAdapter.AlarmViewHolder>() {

    private companion object {
        private val timeFormatter = SimpleDateFormat.getTimeInstance()
    }

    private var items: List<AlarmEntity> = emptyList()

    fun submitList(list: List<AlarmEntity>){
        items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        return AlarmViewHolder(ItemListingBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class AlarmViewHolder(private val binding: ItemListingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(alarm: AlarmEntity){
            binding.days = alarm.days.toShortString()
            binding.description = alarm.name
            binding.isChecked = alarm.enabled
            binding.time = timeFormatter.format(alarm.time)
        }
    }

}