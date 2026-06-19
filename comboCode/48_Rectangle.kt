package comboCode

fun main() {
    print("Введите ширину: ")
    val width = readln().toInt()
    print("Введите высоту: ")
    val height = readln().toInt()
    print("Введите символ: ")
    val symbol = readln()

    printRectangle(symbol, width, height)
}

fun printRectangle(symbol : String, width : Int, height : Int) {
    for (i in 1 .. height) {
        for (b in 1..width) {
            print(symbol)
        }
        println()
    }
}
