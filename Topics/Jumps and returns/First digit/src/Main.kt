fun main() {
    val s = readln()
    for (element in s) {
        if (element.isDigit()) {
            println(element)
            break
        }
    }
}