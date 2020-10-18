package com.example.madlevel4task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Game_table")
class Game(

    @ColumnInfo(name = "date")
    val date: Date,
    @ColumnInfo(name = "computerchoice")
    val computerChoice: Short,
    @ColumnInfo(name = "playerchoice")
    val playerMove: Short,
    @ColumnInfo(name = "result")
    val result: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)