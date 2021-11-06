package com.app.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.roomdatabase.repository.UserRepository
import com.app.roomdatabase.data.userDatabase
import com.app.roomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Userviewmodel(application: Application) : AndroidViewModel(application) {

    val readalldata : LiveData<List<User>>

    private val repository: UserRepository

    init {
        val userdao = userDatabase.getDatabase(application).userDao()
        repository = UserRepository(userdao)
        readalldata = repository.readAllData
    }

    fun adduser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateuser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateuser(user)
        }
    }

    fun deleteuser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteuser(user)
        }
    }

    fun deleteallusers()
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteallusers()
        }
    }
}