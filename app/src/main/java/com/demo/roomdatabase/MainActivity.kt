package com.demo.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBase: ContactDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        dataBase = Room.databaseBuilder(this@MainActivity,
//        ContactDataBase::class.java,
//        "contactDB").build()

        // now we use companion object for singleton object creation, becuase if we have already instance then why we need more to create
        // for this we use companion obj


        dataBase = ContactDataBase.getDatabase(this@MainActivity)

//        GlobalScope.launch {
//            dataBase.contactDao().insertContact(Contact(0,"kuchh bhi", "8795589006"))
//
//        }

        dataBase.contactDao().getContact().observe(this) {
            it.forEach { element ->
                Log.d(
                    "tagCheck",
                    element.id.toString() + "   " + element.name + "   " + element.phone
                )
            }
        }
    }

    fun setData() {

        GlobalScope.launch {
            dataBase.contactDao().insertContact(Contact(0,"kuchh bhi", "8795589006"))

        }



//            dataBase.contactDao().getContact().observe(this, Observer {
//                for (element in it){
//                    Log.d("tagCheck", element.id.toString() + "   " +element.name + "   " + element.phone)
//                }
//            })



    }
}