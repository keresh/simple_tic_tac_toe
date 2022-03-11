fun main() {
    val s = readLine()!!
    println(
        if (s == s.reversed()) {
            "yes"
        } else {
            "no"
        }
    )
}