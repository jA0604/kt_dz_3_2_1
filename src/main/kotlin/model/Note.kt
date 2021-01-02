package model

data class Note (
    val id: Int = 0,
    val ownerIid: Int = 0,

    val title: String = "",
    val text: String = "",
    val date: Long = 0L,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "",


)
{

}
