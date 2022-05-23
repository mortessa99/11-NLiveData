package com.example.a11_nlivedata.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a11_nlivedata.utils.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id : Int ,
    var title : String ,
    var description : String
)