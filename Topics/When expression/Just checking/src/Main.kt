const val NUM_ONE = 1
const val NUM_TWO = 2
const val NUM_FOUR = 4

fun main() {
    val languageNumber = readln().toInt()
    println(
        when (languageNumber) {
            NUM_TWO -> "Yes!"
            in NUM_ONE..NUM_FOUR -> "No!"
            else -> "Unknown number"
        }
    )
}