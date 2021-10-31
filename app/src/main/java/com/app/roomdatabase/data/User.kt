package com.app.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val firstname : String,
    val lastname : String,
    val age : Int
)