package com.demo.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {


//    @Insert
//    fun insertContact(contact: Contact)
//
//    @Update
//    fun updateContact(contact: Contact)
//
//    @Delete
//    fun deleteContact(contact: Contact)
//
//    @Query("SELECT * FROM contact")
//    fun getContact() : List<Contact>
//
//

    // for coroutine we use suspend functions, to run this execution in background thread

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)
//
    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>>

// we use live data, by default room  have livedata functionality
    // when any member have live data return type then it execute on background thread so we don't need suspend function



}