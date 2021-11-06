package com.app.roomdatabase.repository

import com.app.roomdatabase.data.Userdao
import com.app.roomdatabase.model.User

class UserRepository(private val userdao: Userdao) {

    val readAllData = userdao.readalldata()

    fun addUser(user : User)
    {
        userdao.adduser(user)
    }

    suspend fun updateuser(user:User)
    {
        userdao.updateuser(user)
    }

    suspend fun deleteuser(user:User)
    {
        userdao.deleteuser(user)
    }

    suspend fun deleteallusers()
    {
        userdao.deleteallusers()
    }

}