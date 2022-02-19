package com.demo.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {


    abstract fun contactDao() : ContactDao

    companion object{
        @Volatile
        private var INSTANCE : ContactDataBase? = null

        fun getDatabase(context: Context) : ContactDataBase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDataBase::class.java,
                        "contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }

}