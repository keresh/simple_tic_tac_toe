fun main() {
    val s = readLine()!!
    println(
        if (s.length % 2 == 0) {
            s.removeRange(IntRange(s.length / 2 - 1, s.length / 2))
        } else {
            s.removeRange(IntRange(s.length / 2, s.length / 2))
        }
    )
}