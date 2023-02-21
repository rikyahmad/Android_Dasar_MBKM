package com.staygrateful.mbkmsample.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.staygrateful.mbkmsample.data.model.SampleModel
import com.staygrateful.mbkmsample.databinding.ListItemGridBinding

class GridAdapter : ListAdapter<SampleModel, GridAdapter.ViewHolder>(SampleModel.DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val binding = ListItemGridBinding.inflate(li, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData(currentList.getOrNull(position))
    }

    class ViewHolder(
        private val binding: ListItemGridBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBindData(data: SampleModel?) {
            if (data != null) {
                //modify this
            }
        }
    }
}