package service

import model.Comment
import model.Note

class NoteService {

    private var notes: BaseDao<Note> = BaseDao()
    private var comments: BaseDao<Comment> = BaseDao()

    fun add(note: Note) {
        notes.create(note)
    }

    fun createComment(comment: Comment) {
        comments.create(comment)
    }

    fun delete(id: Int) {
        notes.delete(id)
    }

    fun deleteComment(id: Int) {
        comments.delete(id)
    }

    fun get(): List<Note> = notes.read()

    fun getById(id: Int): Note {
        return notes.readById(id) ?: Note()
    }

    fun getComments(): List<Comment> = comments.read()

    fun restoreComment(id: Int) {
        comments.restore(id)
    }
}