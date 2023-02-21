package com.staygrateful.mbkmsample.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "mhs_table")
class MhsRoomModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var mhsName: String? = null,
    var mhsUniv: String? = null,
) : Parcelable {

    object DiffUtilCallback : DiffUtil.ItemCallback<MhsRoomModel>() {
        override fun areItemsTheSame(oldItem: MhsRoomModel, newItem: MhsRoomModel): Boolean {
            return oldItem.mhsName == newItem.mhsName
                    && oldItem.mhsUniv == newItem.mhsUniv
        }

        override fun areContentsTheSame(oldItem: MhsRoomModel, newItem: MhsRoomModel): Boolean {
            return oldItem.mhsName == newItem.mhsName
                    && oldItem.mhsUniv == newItem.mhsUniv
        }
    }
}