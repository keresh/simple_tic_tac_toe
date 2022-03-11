fun main() {
    val (s, n) = readLine()!!.split(" ")
    println(
        if (n.toInt() >= s.length) {
            s
        } else {
            "${s.substring(n.toInt(), s.length)}${s.substring(0, n.toInt())}"
        }
    )
}