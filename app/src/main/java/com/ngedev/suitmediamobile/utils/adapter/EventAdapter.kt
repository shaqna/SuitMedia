package com.ngedev.suitmediamobile.utils.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngedev.suitmediamobile.databinding.ItemEventBinding
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.ui.screen2.SecondActivity
import com.ngedev.suitmediamobile.utils.Constants

class EventAdapter(private val context: Context) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val events = arrayListOf<Event>()

    fun setItems(event: List<Event>) {
        Log.d("Dataku", event.toString())
        events.clear()
        events.addAll(event)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class ViewHolder(private val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(event: Event) {
                with(binding){
                    tvTitle.text = event.title
                    tvDescription.text = event.description
                    tvDate.text = event.date
                    tvTime.text = event.time
                }
                Glide.with(itemView.context).load(event.image).into(binding.imageEvent)

                itemView.setOnClickListener {
                    context.startActivity(
                        Intent(
                            itemView.context,SecondActivity::class.java,
                        ).putExtra(Constants.EVENT_NAME, event.title)
                    )
                }
            }


    }
}