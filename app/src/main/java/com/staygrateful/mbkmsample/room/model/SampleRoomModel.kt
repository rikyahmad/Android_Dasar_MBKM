package com.staygrateful.mbkmsample.room.model

import android.os.Parcelable
import androidx.room.*
import com.staygrateful.mbkmsample.room.converter.ListConverter
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "example", indices = [Index(value = ["dataId"], unique = true)])
class SampleRoomModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var field1: String? = null,
    var field2: String? = null,
    @TypeConverters(ListConverter::class)
    var product: List<String>? = null
) : Parcelable