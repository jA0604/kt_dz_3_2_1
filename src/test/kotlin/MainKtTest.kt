import model.*
import org.junit.Test
import service.NoteService

class MainKtTest {
    private val noteService = NoteService()

    @Test
    fun createNote() {

        var note = Note(id = 0, ownerIid = 0, title = "Title 1", text = "Test text on Note 1",
            date = 1609879870328798L, comments = 1, readComments = 0, viewUrl = "url_note")

        val expected = 2

        noteService.add(note)
        note = note.copy(id = 1)
        noteService.add(note)
        note = note.copy(id = 2, title = "DDDD AA DDDD")
        noteService.add(note)
        note = note.copy(id = 3)
        noteService.add(note)
        val result = noteService.getById(2)
        assert(expected == result.id)
    }

    @Test
    fun createComment() {
        var comment = Comment(
            fromId = 23,
            date = 160456879246540L,
            text = "comment text",
            placeholder = "placeholder 34",
            replyToUser = 45,
            replyToComment = 2
        )

        val expected = "comment 2 text "

        noteService.createComment(comment)
        comment = comment.copy(id = 1)
        noteService.createComment(comment)
        comment = comment.copy(id = 2, text = "comment 2 text ")
        noteService.createComment(comment)
        comment = comment.copy(id = 3, text = "comment 3 text ")
        noteService.createComment(comment)
        val result = noteService.getComments()

        assert(expected == result[2].text)

    }

    @Test
    fun getNoteAndComment() {

        var note = Note(id = 0, ownerIid = 0, title = "Title 1", text = "Test text on Note 1",
            date = 1609879870328798L, comments = 1, readComments = 0, viewUrl = "url_note")

        var comment = Comment(
            fromId = 23,
            date = 160456879246540L,
            text = "comment text",
            placeholder = "placeholder 34",
            replyToUser = 45,
            replyToComment = 2
        )

        noteService.add(note)
        note = note.copy(id = 1)
        noteService.add(note)
        note = note.copy(id = 2, title = "DDDD AA DDDD")
        noteService.add(note)
        note = note.copy(id = 3)
        noteService.add(note)

        noteService.delete(1)
        val showListNote = noteService.get()

        var result = showListNote.size == 3

        noteService.createComment(comment)
        comment = comment.copy(id = 1)
        noteService.createComment(comment)
        comment = comment.copy(id = 2, text = "comment 2 text ")
        noteService.createComment(comment)
        comment = comment.copy(id = 3, text = "comment 3 text ")
        noteService.createComment(comment)

        noteService.deleteComment(2)
        val showListComment = noteService.getComments()
        result = result && showListComment.size == 3

        assert(result)

    }

    @Test
    fun restoreComment() {

        var note = Note(id = 0, ownerIid = 0, title = "Title 1", text = "Test text on Note 1",
            date = 1609879870328798L, comments = 1, readComments = 0, viewUrl = "url_note")

        var comment = Comment(
            fromId = 23,
            date = 160456879246540L,
            text = "comment text",
            placeholder = "placeholder 34",
            replyToUser = 45,
            replyToComment = 2
        )

        noteService.add(note)
        note = note.copy(id = 1)
        noteService.add(note)
        note = note.copy(id = 2, title = "DDDD AA DDDD")
        noteService.add(note)
        note = note.copy(id = 3)
        noteService.add(note)

        noteService.delete(1)
        val showListNote = noteService.get()

        var result = showListNote.size == 3

        noteService.createComment(comment)
        comment = comment.copy(id = 1)
        noteService.createComment(comment)
        comment = comment.copy(id = 2, text = "comment 2 text ")
        noteService.createComment(comment)
        comment = comment.copy(id = 3, text = "comment 3 text ")
        noteService.createComment(comment)

        noteService.deleteComment(2)
        var showListComment = noteService.getComments()
        result = result && showListComment.size == 3
        noteService.restoreComment(2)
        showListComment = noteService.getComments()
        result = result && showListComment.size == 4

        assert(result)

    }
}