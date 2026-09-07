
fun formatDuration(minutes: Int): String {
    val hours = minutes/60
    val mins= minutes%60
    return "${hours}h ${mins}m"

}


fun main(){
    println(formatDuration(0))
    println(formatDuration(60))
    println(formatDuration(120))
    println(formatDuration(135))
    println(formatDuration(180))
}