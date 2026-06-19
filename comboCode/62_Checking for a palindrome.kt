package comboCode

fun main() {
    print("Введите слово: ")
    val text = readln()

    var isPalindrome = true

    for (i in 0 until text.length / 2) {
        if (text[i] != text[text.length - 1 - i]) {
            isPalindrome = false
            break
        }

    }
    println(isPalindrome)
}