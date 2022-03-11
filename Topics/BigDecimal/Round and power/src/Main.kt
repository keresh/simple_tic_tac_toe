import java.math.BigDecimal
import java.math.RoundingMode     

fun main() {
    val power = readLine()!!.toInt()
    val mode = readLine()!!.toInt()
    val number = BigDecimal(readLine()!!)
    val rounded = number.setScale(mode, RoundingMode.FLOOR)
    println(rounded.pow(power))
}