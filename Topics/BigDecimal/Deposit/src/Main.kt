import java.math.BigDecimal
import java.math.RoundingMode

const val NUM_TWO = 2

fun main() {
    val amount = readln().toBigDecimal()
    val rate = readln().toBigDecimal()
    val years = readln().toInt()
    val result = amount * (BigDecimal.ONE + rate.setScale(NUM_TWO, RoundingMode.CEILING) / BigDecimal("100")).pow(years)
    println("Amount of money in the account: ${result.setScale(NUM_TWO, RoundingMode.CEILING)}")
}