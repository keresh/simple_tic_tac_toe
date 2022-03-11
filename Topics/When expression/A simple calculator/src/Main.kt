fun main() {
    val (var1, op, var2) = readln().split(" ")

    val a = var1.toLong()
    val b = var2.toLong()

    println(
        when (op) {
            "+" -> a + b
            "-" -> a - b
            "/" ->
                if (b == 0.toLong()) {
                    "Division by 0!"
                } else {
                    a / b
                }
            "*" -> a * b
            else -> "Unknown operator"
        }
    )
}