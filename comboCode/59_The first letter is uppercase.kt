package comboCode

fun main() {
    print("Введите текст: ")
    val text = readln()

    if (text.isEmpty()) {
        println(" ")
        return
    }

    val result = text[0].uppercase() + text.substring(1)
    println(result)
}