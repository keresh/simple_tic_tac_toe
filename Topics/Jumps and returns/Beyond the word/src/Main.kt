fun main() {
    val s = readln()
    for (i in 'a'..'z') {
        if (s.contains(i)) continue
        print(i)
    }
}