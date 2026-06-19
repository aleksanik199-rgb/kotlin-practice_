package comboCode

fun main() {
    print("Введите предложение: ")
    val sentence = readln()
    val lower = sentence.lowercase()
    val lineLength = sentence.length
    var spaces = 0
    var vowels = 0

    for (ch in lower) {
        if (ch == ' ') spaces++
        if (ch in "аеёиоуыэюя") vowels++
    }
    println("Длина строки: $lineLength")
    println("Пробелов: $spaces")
    println("Гласных (русских): $vowels")
}