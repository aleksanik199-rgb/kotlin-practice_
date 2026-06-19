package comboCode

fun main() {
    val numbers = listOf(34, 12, 89, 45, 23, 11, 90)

    val maxNumber = findMax(numbers)
    println("Масимальное число: $maxNumber")
}

fun findMax(numbers: List<Int>): Int {
    if (numbers.isEmpty()) return Int.MIN_VALUE
    var max = numbers[0]
    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }
    return max
}