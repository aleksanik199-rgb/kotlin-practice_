package comboCode

fun main() {
    print("Введите слово: ")
    val text = readln()


    var reversed = text.reversed()
    var isPalindrome = text == reversed
    println(isPalindrome)

}