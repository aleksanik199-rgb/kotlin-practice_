package comboCode

fun main() {
    print("Введите предложение: ")
    val sentence = readln()
    var count = 0

    for (ch in sentence){
        if (ch == ' '){
            count++
        }
    }
    println("Количество пробелов: $count")
}