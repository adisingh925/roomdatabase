package com.app.roomdatabase.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.roomdatabase.data.User
import com.app.roomdatabase.data.UserRepository
import com.app.roomdatabase.data.userDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Userviewmodel(application: Application) : AndroidViewModel(application) {

    private val readalldata : LiveData<List<User>>

    private val repository: UserRepository

    init {
        val userdao = userDatabase.getDatabase(application).userDao()
        repository = UserRepository(userdao)
        readalldata = repository.readAllData
    }

    fun adduser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}