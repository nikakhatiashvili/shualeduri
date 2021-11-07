package com.example.project.callback

import com.example.project.model.agents.Ability
import com.example.project.model.agents.Role


interface ClickListener {
    fun onClick(ability: List<Ability>)
}