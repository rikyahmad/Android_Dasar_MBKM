package com.staygrateful.mbkmsample.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.databinding.ListItemMhsBinding

class MhsListAdapter(
    private val deleteListener: DeleteListener
) : ListAdapter<MhsRoomModel, MhsListAdapter.ViewHolder>(MhsRoomModel.DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val binding = ListItemMhsBinding.inflate(li, parent, false)
        return ViewHolder(binding, this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData(currentList.getOrNull(position))
    }

    class ViewHolder(
        private val binding: ListItemMhsBinding,
        private val adapter: MhsListAdapter
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnDelete.setOnClickListener {
                adapter.deleteListener.onClickDelete(adapter, adapterPosition)
            }
        }

        fun onBindData(data: MhsRoomModel?) {
            if (data != null) {
                binding.name.text = data.mhsName
                binding.univ.text = data.mhsUniv
            }
        }
    }
}

interface DeleteListener {
    fun onClickDelete(adapter: MhsListAdapter, index: Int)
}