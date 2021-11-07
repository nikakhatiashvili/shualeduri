package com.example.project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    val email:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}