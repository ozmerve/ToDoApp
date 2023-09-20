package com.merveoz.todoapp.data.source

import com.merveoz.todoapp.data.model.Note

object Database {

    //bu obje içinde kullanılabilecek bir nesne oluşturduk:
    private val dailynotes = mutableListOf<Note>()

    //bu listeyi çağırmak için fonksiyon oluşturduk:
    fun getDailyNotes(): List<Note> {
        return dailynotes
    }

    //veri eklemek için fonksiyon oluşturduk, id'nin otomatik artması için parametre olarak yazmadık
    fun addDailyNote(title: String, description: String, priorityColorId: Int){
        val newNote = Note(
            id = (dailynotes.lastOrNull()?.id?:0)+1, //listenin son elemanını getir, getiremezsen null döndür. null değilse id'sini al, null ise 0 döndür. yeni veri eklerken 1 artır
            title = title,
            description = description,
            priorityColorId = priorityColorId
        )
        dailynotes.add(newNote)
    }
    fun removeDailyNoteById(id: Int) {
        val noteToRemove = dailynotes.find { it.id == id }
        if(noteToRemove != null) {
            dailynotes.remove(noteToRemove)
        }
    }








































































}