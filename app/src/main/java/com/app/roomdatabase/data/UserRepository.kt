package com.app.roomdatabase.data

import com.app.roomdatabase.data.User
import com.app.roomdatabase.data.Userdao

class UserRepository(private val userdao: Userdao) {

    val readAllData = userdao.readalldata()

    fun addUser(user : User)
    {
        userdao.adduser(user)
    }

}