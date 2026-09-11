
fun formatDuration(minutes: Int): String {
    val hours = minutes/60
    val mins= minutes%60
    return "${hours}h ${mins}m"

}




fun myfun():String{
    var x:String = ""
    return x
}

fun convert_str_int(mynum:String):Int{
    var int_num= mynum.toInt()
    return int_num

}
fun check_number_even_odd(mynum:String){
    var num = convert_str_int(mynum)



}

//fun main(){
//    println(formatDuration(0))
//    println(formatDuration(60))
//    println(formatDuration(120))
//    println(formatDuration(135))
//    println(formatDuration(180))
//    null_checking()
//}


data class Book(
    val title: String,
    val pages: Int
)

fun main() {

    val books = listOf(
        Book("Esha", 320),
        Book("The Alchemist", 208),
        Book("Clean Code", 464),
        Book("Deep Work", 304),
        Book("Dune", 688),
        Book("Educated", 400),
        Book("Frankenstein", 280),
        Book("Harry Potter", 636),
        Book("Ikigai", 208),
        Book("JavaScript: The Good Parts", 176),
        Book("Kotlin in Action", 360),
        Book("Lord of the Rings", 1178),
        Book("Meditations", 256),
        Book("Pride and Prejudice", 432),
        Book("The Hobbit", 310)
    )

    // Longest three books
    val longestThree = books
        .sortedBy { it.pages }
        .takeLast(3)
        .reversed()

    println("Longest three:")
    longestThree.forEach {
        println("${it.title} - ${it.pages} pages")
    }

    // Total pages
    val totalPages = books.sumOf { it.pages }

    println("\nTotal pages: $totalPages")

    // Group by first letter
    val groupedByLetter = books.groupBy {
        it.title.first()
    }

    println("\nGrouped by first letter:")
    groupedByLetter.forEach { (letter, books) ->
        println("$letter: ${books.map { it.title }}")
    }
}

//Longest three:
//Lord of the Rings - 1178 pages
//Dune - 688 pages
//Harry Potter - 636 pages
//
//Total pages: 6220
//
//Grouped by first letter:
//A: [Atomic Habits]
//T: [The Alchemist, The Hobbit]
//C: [Clean Code]
//D: [Deep Work, Dune]
//E: [Educated]
//F: [Frankenstein]
//H: [Harry Potter]
//I: [Ikigai]
//J: [JavaScript: The Good Parts]
//K: [Kotlin in Action]
//L: [Lord of the Rings]
//M: [Meditations]
//P: [Pride and Prejudice]


fun getStatus(percentage: Int): String {
    return when (percentage) {
        in 0..24 -> "Not started"
        in 25..49 -> "Started"
        in 50..74 -> "Halfway"
        in 75..99 -> "Almost complete"
        100 -> "Completed"
        else -> "Invalid percentage"
    }
}

fun main(){
    println(getStatus(0))
    println(getStatus(25))
    println(getStatus(50))
    println(getStatus(80))
    println(getStatus(100))

}
//Not started
//Started
//Halfway
//Almost complete
//Completed
