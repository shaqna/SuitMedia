package com.ngedev.suitmediamobile.utils.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngedev.suitmediamobile.databinding.ItemGuestBinding
import com.ngedev.suitmediamobile.domain.model.User

class GuestAdapter : PagingDataAdapter<User, GuestAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.id == newItem.id
    }
) {

    var onUserClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestAdapter.ViewHolder {
        val itemBinding =
            ItemGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: GuestAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            Log.d("MyItem", item.toString())
            with(binding) {
                val name = "${item.firstName} ${item.lastName}"
                tvTitle.text = name
                Glide.with(itemView.context)
                    .load(item.avatar)
                    .into(imageEvent)

                root.setOnClickListener {
                    onUserClickListener?.invoke(item.firstName)
                }
            }
        }
    }
}