package com.example.project.callback

import com.example.project.model.agents.Ability



interface ClickListener {
    fun onClick(ability: List<Ability>)
}