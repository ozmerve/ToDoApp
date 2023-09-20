package com.merveoz.todoapp.data.model

import com.merveoz.todoapp.R

enum class Priority( val priorityColorId: Int){
    HIGH(R.color.highPriorityColor),
    MEDIUM(R.color.mediumPriorityColor),
    LOW(R.color.lowPriorityColor);
}