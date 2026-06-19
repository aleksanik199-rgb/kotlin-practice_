package comboCode

fun main() {
    print("Введите имя: ")
    val name = readln()
    print("Введите число: ")
    val number = readln().toInt()
    print("Введите цвет: ")
    val color = readln()

    if (color.isEmpty()) return

    val nameLength = name.length
    val firstChar = color[0]
    val lowerChar = firstChar.lowercase()
    var nickname = color + name + number


    if (nameLength < 3){
        nickname += "х3"
    }
    if (number % 2 == 0) {
        nickname = "Even_" + nickname
    }
    if (lowerChar in "аеёиоуыэюя") {
        nickname += "!"
    }

    println(nickname)
}