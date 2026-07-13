package algorithmic_logic

fun main() {
    val n = readln().toInt()
    val s = readln().trim().split(" ").map { it.toInt() }
    val score = readln().toInt()

    val index = studentScoreIndex(n, s, score)

    println(index)
}

fun studentScoreIndex(n: Int, s: List<Int>, score: Int): Int {
    var left = 0
    var right = s.size - 1
    var result = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (s[mid] <= score) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return result
}