package com.example.project.callback

import android.widget.ImageButton



interface ClickListenerForSave {
    fun onClick(data: String,image:String,imgbtn: ImageButton)
}