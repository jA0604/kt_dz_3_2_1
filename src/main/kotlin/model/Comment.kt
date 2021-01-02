package model

data class Comment (
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Long = 0L,
    val text: String = "",
    val donut: Donut = Donut(),
    val isDon: Boolean = false,
    val placeholder: String = "",
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray(),
    val threadComments: ThreadComments = ThreadComments()
    ) {

}
