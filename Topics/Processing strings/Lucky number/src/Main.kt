const val NUM_ZERO = 0
const val NUM_TWO = 2

fun main() {
    val n = readLine()!!
    val firstHalf = n.substring(NUM_ZERO, n.length / NUM_TWO)
    val secondHalf = n.substring(n.length / NUM_TWO)
    println(
        if (sumDigits(firstHalf) == sumDigits(secondHalf)) {
            "YES"
        } else {
            "NO"
        }
    )
}

fun sumDigits(number: String): Int {
    var sum = NUM_ZERO
    for (element in number) sum += element.code
    return sum
}