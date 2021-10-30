package com.app.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface Userdao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun adduser(user : User)

    @Query("SELECT * from user_data order by id asc")
    fun readalldata() : LiveData<List<User>>
}