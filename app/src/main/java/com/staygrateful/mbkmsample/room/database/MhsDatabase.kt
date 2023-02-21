package com.staygrateful.mbkmsample.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.staygrateful.mbkmsample.data.Data
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.room.dao.MhsDao
import java.util.concurrent.Executors

@Database(entities = [MhsRoomModel::class], version = 1)
abstract class MhsDatabase : RoomDatabase() {
    abstract fun mhsDao(): MhsDao

    companion object {

        private var instance: MhsDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MhsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MhsDatabase::class.java,
                    "MhsDatabase"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //pre-populate data
                        Executors.newSingleThreadExecutor().execute {
                            instance?.mhsDao()?.insertList(Data.MHS_ROOM_DATA)
                        }
                    }
                }).fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }
}