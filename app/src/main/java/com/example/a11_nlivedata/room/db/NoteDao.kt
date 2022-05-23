package com.example.a11_nlivedata.room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a11_nlivedata.utils.NOTE_TABLE

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(note: Note)

    @Query("SELECT * FROM $NOTE_TABLE")
    fun getAllNotes():LiveData<MutableList<Note>>
}