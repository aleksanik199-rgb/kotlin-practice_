package comboCode

fun main() {
    print("Введите текст: ")
    val text = readln()

    var spaceCount = 0
    for (ch in text) {
        if (ch == ' ') spaceCount++
    }
    println("Колличество пробелов: $spaceCount")
}
