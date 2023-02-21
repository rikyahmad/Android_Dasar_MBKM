package com.staygrateful.mbkmsample.data.model

import androidx.recyclerview.widget.DiffUtil

class SampleModel(
    var id: Int = 0,
    var title: String? = null,
    var desc: String? = null,
) {

    object DiffUtilCallback : DiffUtil.ItemCallback<SampleModel>() {
        override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.title == newItem.title
                    && oldItem.desc == newItem.desc
        }

        override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.title == newItem.title
                    && oldItem.desc == newItem.desc
        }
    }
}