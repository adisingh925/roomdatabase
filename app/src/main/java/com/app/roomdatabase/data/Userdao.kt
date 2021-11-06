package com.app.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.roomdatabase.model.User


@Dao
interface Userdao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun adduser(user : User)

    @Update
    suspend fun updateuser(user :User)

    @Delete
    suspend fun deleteuser(user:User)

    @Query("DELETE FROM user_data")
    suspend fun deleteallusers()

    @Query("SELECT * from user_data order by id asc")
    fun readalldata() : LiveData<List<User>>
}