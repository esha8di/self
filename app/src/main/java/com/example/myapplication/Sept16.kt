import kotlinx.coroutines.*

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

suspend fun loadBooks(): List<Book> {

    println("Loading books...")

    delay(2000)

    return listOf(
        Book(
            "Clean Code",
            464,
            ReadingStatus.COMPLETED
        ),
        Book(
            "Kotlin Basics",
            300,
            ReadingStatus.READING
        ),
        Book(
            "The Pragmatic Programmer",
            352,
            ReadingStatus.NOT_STARTED
        )
    )
}

fun main() = runBlocking {

    launch {

        val books = loadBooks()

        println("\nBooks loaded:")

        books.forEach { book ->
            println(
                "${book.title} - " +
                        "${book.pages} pages - " +
                        "${book.readingStatus}"
            )
        }
    }
}