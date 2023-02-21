package com.staygrateful.mbkmsample.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.staygrateful.mbkmsample.data.model.MhsRoomModel

@Dao
interface MhsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: MhsRoomModel?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(dataList: MutableList<MhsRoomModel>?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(data: MhsRoomModel?)

    @Delete
    fun delete(data: MhsRoomModel?)

    @Delete
    fun deleteList(dataList: MutableList<MhsRoomModel>?)

    @Query("DELETE FROM mhs_table")
    fun deleteAll()

    @Query("UPDATE mhs_table SET mhsName=:mhsName WHERE id=:id")
    fun updateMhsName(id: Int, mhsName: String)

    @get:Query("SELECT COUNT(id) FROM mhs_table")
    val dataCount: Int

    @get:Query("SELECT * FROM mhs_table")
    val dataList: MutableList<MhsRoomModel>

    @get:Query("SELECT * FROM mhs_table")
    val dataLiveData: LiveData<MutableList<MhsRoomModel>>
}