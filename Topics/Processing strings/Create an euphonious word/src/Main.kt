const val VOWELS = "aeiouy"
const val NUM_ZERO = 0
const val NUM_ONE = 1
const val NUM_THREE = 3

fun main() {
    val input = readLine()!!
    var charCount = NUM_ZERO
    var vowelCount = NUM_ZERO
    var consonantCount = NUM_ZERO
    for (i in input) {
        if (i in VOWELS) {
            vowelCount++
            consonantCount = NUM_ZERO
        } else {
            consonantCount++
            vowelCount = NUM_ZERO
        }
        if (vowelCount == NUM_THREE) {
            charCount++
            vowelCount = NUM_ONE
            consonantCount = NUM_ZERO
        } else if (consonantCount == NUM_THREE) {
            charCount++
            vowelCount = NUM_ZERO
            consonantCount = NUM_ONE
        }
    }
    println(charCount)
}