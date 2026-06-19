package comboCode

fun main() {
    print("Введите текст: ")
    val text = readln()

    var reverse = ""
    val words = text.split(" ")
    for (i in words.indices.reversed()) {
        reverse += words[i] + " "
    }
    println(reverse.trim())
}