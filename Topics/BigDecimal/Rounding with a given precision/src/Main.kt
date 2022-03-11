import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    val num = BigDecimal(readLine()!!)
    val scale = readLine()!!.toInt()
    println(num.setScale(scale, RoundingMode.HALF_DOWN))
}