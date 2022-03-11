fun main() {
    val s = readln()
    for (i in 'a'..'z') {
        if (i.toString() == s) break
        print(i)
    }
}