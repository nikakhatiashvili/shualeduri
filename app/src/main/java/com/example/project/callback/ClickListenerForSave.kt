package com.example.project.callback

import android.widget.ImageButton
import android.widget.ImageView
import com.example.project.model.sprays.SpraysData


interface ClickListenerForSave {
    fun onClick(data: String,image:String,imgbtn: ImageButton)
}