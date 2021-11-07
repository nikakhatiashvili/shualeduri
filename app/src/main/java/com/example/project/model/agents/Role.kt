package com.example.project.model.agents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Role(
    val assetPath: String?,
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val uuid: String?
):Parcelable