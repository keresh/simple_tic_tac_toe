const val NUM_ZERO = 0
const val NUM_ONE = 1
const val NUM_TWO = 2
const val NUM_THREE = 3
const val NUM_FOUR = 4

fun main() {
    println(
        when (readln().toInt()) {
            NUM_ZERO -> "do not move"
            NUM_ONE -> "move up"
            NUM_TWO -> "move down"
            NUM_THREE -> "move left"
            NUM_FOUR -> "move right"
            else -> "error!"
        }
    )
}