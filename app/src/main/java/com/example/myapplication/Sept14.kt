enum class ReadingStatus {
    NOT_STARTED,
    READING,
    COMPLETED
}

data class Book(
    val title: String,
    val pages: Int,
    val readingStatus: ReadingStatus
)

sealed class SaveResult {
    data object Success : SaveResult()
    data class Error(val message: String) : SaveResult()
}

fun saveBook(book: Book): SaveResult {
    return if (book.title.isNotEmpty()) {
        SaveResult.Success
    } else {
        SaveResult.Error("Book title cannot be empty")
    }
}

fun main() {

    val book = Book(
        title = "Kotlin Basics",
        pages = 250,
        readingStatus = ReadingStatus.READING
    )

    val result = saveBook(book)

    when (result) {
        SaveResult.Success -> println("Book saved!")
        is SaveResult.Error -> println(result.message)
    }
}