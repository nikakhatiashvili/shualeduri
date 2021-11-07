package com.example.project.model.saved

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "favorites")
data class SavedSprays(
    val photo:String?,
    val name:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}