package comboCode

fun main() {
    print("Введите текст: ")
    val text = readln()

    var result = ""
    for(ch in text) {
        if (ch != ' ') result += ch
    }
    println(result)
}