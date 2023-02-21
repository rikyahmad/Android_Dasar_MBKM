package com.staygrateful.mbkmsample.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.room.dao.MhsDao
import com.staygrateful.mbkmsample.room.database.MhsDatabase

class MhsViewModel constructor(
    application: Application
) : AndroidViewModel(application), MhsDao {

    private val dao: MhsDao

    init {
        val db = MhsDatabase.getInstance(application)
        dao = db.mhsDao()
    }

    override fun insert(data: MhsRoomModel?) {
        Thread {
            dao.insert(data)
        }.start()
    }

    override fun insertList(dataList: MutableList<MhsRoomModel>?) {
        Thread {
            dao.insertList(dataList)
        }.start()
    }

    override fun update(data: MhsRoomModel?) {
        Thread {
            dao.update(data)
        }.start()
    }

    override fun delete(data: MhsRoomModel?) {
        Thread {
            dao.delete(data)
        }.start()
    }

    override fun deleteList(dataList: MutableList<MhsRoomModel>?) {

    }

    override fun deleteAll() {

    }

    override fun updateMhsName(id: Int, mhsName: String) {

    }

    override val dataCount: Int
        get() = dao.dataCount

    override val dataList: MutableList<MhsRoomModel>
        get() = dao.dataList

    override val dataLiveData: LiveData<MutableList<MhsRoomModel>>
        get() = dao.dataLiveData
}