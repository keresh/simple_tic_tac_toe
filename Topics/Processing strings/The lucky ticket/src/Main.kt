const val NUM_TWO = 2

fun main() {
    val ticketNumber: MutableList<Int> =
        readLine()!!.map { it.digitToInt() }.toMutableList()
    val midVal = ticketNumber.size / NUM_TWO
    println(
        if (ticketNumber.subList(0, midVal).sum() == ticketNumber.subList(midVal, ticketNumber.size).sum()) {
            "Lucky"
        } else {
            "Regular"
        }
    )
}