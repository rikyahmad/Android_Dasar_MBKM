package com.staygrateful.mbkmsample.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.databinding.ListItemMhsBinding

class MhsAdapter : RecyclerView.Adapter<MhsAdapter.ViewHolder>() {

    private var items: MutableList<MhsRoomModel> = mutableListOf()

    fun setItem(items: MutableList<MhsRoomModel>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val binding = ListItemMhsBinding.inflate(li, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData(items.getOrNull(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(private val binding: ListItemMhsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindData(data: MhsRoomModel?) {
            if (data != null) {
                binding.name.text = data.mhsName
                binding.univ.text = data.mhsUniv
            }
        }
    }
}