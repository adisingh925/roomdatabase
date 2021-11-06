package com.app.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.roomdatabase.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class userDatabase : RoomDatabase() {

    abstract fun userDao(): Userdao

    companion object{

        @Volatile
        private var INSTANCE : userDatabase? = null

        fun getDatabase(context: Context):userDatabase
        {
            val tempinstance = INSTANCE
            if(tempinstance!=null)
            {
                return tempinstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext,
                    userDatabase::class.java,
                    "user_database").build()

                INSTANCE = instance
                return instance
            }
        }
    }

}