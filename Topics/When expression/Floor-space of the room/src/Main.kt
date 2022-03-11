import kotlin.math.pow
import kotlin.math.sqrt

const val NUM_N = 3.14

fun main() {
    val shape = readln()

    println(
        when (shape) {
            "triangle" -> {
                val a = readln().toDouble()
                val b = readln().toDouble()
                val c = readln().toDouble()
                val p = (a + b + c) / 2.toDouble()
                sqrt(p * (p - a) * (p - b) * (p - c))
            }
            "rectangle" -> {
                val a = readln().toDouble()
                val b = readln().toDouble()
                a * b
            }
            "circle" -> {
                val r = readln().toDouble()
                val n = NUM_N
                n * r.pow(2)
            }
            else -> "Unknown shape"
        }
    )
}