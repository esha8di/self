data class Book(
    var title: String,
    var pages: Int
)

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
                        books.add(Book(title, pages))
                        println("Book added.")
                    }
                }
            }

            "2" -> {
                if (books.isEmpty()) {
                    println("No books found.")
                } else {
                    println("\nBooks:")

                    books.forEachIndexed { index, book ->
                        println("${index + 1}. ${book.title} - ${book.pages} pages")
                    }
                }
            }

            "3" -> {
                if (books.isEmpty()) {
                    println("No books to update.")
                } else {
                    books.forEachIndexed { index, book ->
                        println("${index + 1}. ${book.title} - ${book.pages} pages")
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
                                book.title = newTitle
                                book.pages = newPages
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
                        println("${index + 1}. ${book.title} - ${book.pages} pages")
                    }

                    print("Enter book number to delete: ")
                    val index = readLine()?.trim()?.toIntOrNull()

                    if (index == null || index !in 1..books.size) {
                1        println("Invalid book number.")
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
}`