package comboCode

import kotlin.random.Random

fun main() {
    val length = getValidLength()
    val password = generatePassword(length)

    println("Ваш пароль: $password")
}

fun generatePassword(length: Int): String{
    val lowercase = ('a'..'z').toList()
    val uppercase = ('A'..'Z').toList()
    val digits = ('0'..'9').toList()
    val allChars = lowercase + uppercase + digits
    var password = ""
    for (i in 1..length){
        val randomIndex = Random.nextInt(allChars.size)
        password += allChars[randomIndex]
    }
    return password
}

fun getValidLength(): Int{
    var length: Int
    do {
        print("Введите длину пароля (4-20): ")
        val input = readln().toInt()
        length = input
        if (length !in 4..20){
            println("Ошибка! пароль должен быть в диапазоне от 4 до 20 символов")
        }
    } while (length !in 4..20)
    return length
}