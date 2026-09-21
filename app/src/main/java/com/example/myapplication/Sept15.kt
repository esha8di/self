
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

// Extension function
fun Book.progressPercent(): Int {
    return when (readingStatus) {
        ReadingStatus.NOT_STARTED -> 0
        ReadingStatus.READING -> 50
        ReadingStatus.COMPLETED -> 100
    }
}

sealed class SaveResult {
    data object Success : SaveResult()
    data class Error(val message: String) : SaveResult()
}

fun saveBook(
    book: Book,
    books: MutableList<Book>
): SaveResult {

    if (book.title.isBlank()) {
        return SaveResult.Error("Book title cannot be empty.")
    }

    if (book.pages <= 0) {
        return SaveResult.Error("Pages must be greater than 0.")
    }

    books.add(book)

    return SaveResult.Success
}

fun main() {

    val books = mutableListOf<Book>()

    while (true) {

        println("\n--- Book Shelf ---")
        println("1. Add book")
        println("2. List all books")
        println("3. Update book")
        println("4. Delete book")
        println("5. Quit")
        print("Choose an option: ")

        when (readLine()?.trim()) {

            "1" -> {

                print("Enter book title: ")
                val title = readLine()?.trim()

                if (title.isNullOrBlank()) {
                    println("Invalid title.")
                } else {

                    print("Enter number of pages: ")
                    val pages = readLine()?.trim()?.toIntOrNull()

                    if (pages == null || pages <= 0) {
                        println("Invalid number of pages.")
                    } else {

                        println("Choose reading status:")
                        println("1. Not started")
                        println("2. Reading")
                        println("3. Completed")

                        val status = when (readLine()?.trim()) {
                            "1" -> ReadingStatus.NOT_STARTED
                            "2" -> ReadingStatus.READING
                            "3" -> ReadingStatus.COMPLETED
                            else -> null
                        }

                        // Using let to handle nullable status
                        status?.let { selectedStatus ->

                            val book = Book(
                                title,
                                pages,
                                selectedStatus
                            )

                            val result = saveBook(book, books)

                            when (result) {
                                SaveResult.Success -> {
                                    println("Book added.")
                                }

                                is SaveResult.Error -> {
                                    println(result.message)
                                }
                            }

                        } ?: println("Invalid reading status.")
                    }
                }
            }

            "2" -> {

                if (books.isEmpty()) {
                    println("No books found.")
                } else {

                    println("\nBooks:")

                    books.forEachIndexed { index, book ->

                        println(
                            "${index + 1}. " +
                                    "${book.title} - " +
                                    "${book.pages} pages - " +
                                    "${book.readingStatus} - " +
                                    "${book.progressPercent()}% complete"
                        )
                    }
                }
            }

            "3" -> {

                if (books.isEmpty()) {
                    println("No books to update.")
                } else {

                    books.forEachIndexed { index, book ->
                        println(
                            "${index + 1}. " +
                                    "${book.title} - " +
                                    "${book.pages} pages - " +
                                    "${book.readingStatus}"
                        )
                    }

                    print("Enter book number to update: ")
                    val index = readLine()?.trim()?.toIntOrNull()

                    if (index == null || index !in 1..books.size) {
                        println("Invalid book number.")
                    } else {

                        val book = books[index - 1]

                        print("Enter new title: ")
                        val newTitle = readLine()?.trim()

                        if (newTitle.isNullOrBlank()) {
                            println("Invalid title.")
                        } else {

                            print("Enter new number of pages: ")
                            val newPages = readLine()?.trim()?.toIntOrNull()

                            if (newPages == null || newPages <= 0) {
                                println("Invalid number of pages.")
                            } else {

                                books[index - 1] = book.copy(
                                    title = newTitle,
                                    pages = newPages
                                )

                                println("Book updated.")
                            }
                        }
                    }
                }
            }

            "4" -> {

                if (books.isEmpty()) {
                    println("No books to delete.")
                } else {

                    books.forEachIndexed { index, book ->
                        println(
                            "${index + 1}. " +
                                    "${book.title} - " +
                                    "${book.pages} pages - " +
                                    "${book.readingStatus}"
                        )
                    }

                    print("Enter book number to delete: ")
                    val index = readLine()?.trim()?.toIntOrNull()

                    if (index == null || index !in 1..books.size) {
                        println("Invalid book number.")
                    } else {

                        val removedBook = books.removeAt(index - 1)

                        println("${removedBook.title} deleted.")
                    }
                }
            }

            "5" -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid option. Please choose 1-5.")
            }
        }
    }
}
