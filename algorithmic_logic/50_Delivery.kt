package algorithmic_logic

fun main() {
    val n = readln().toInt()
    val s = readln().trim().split(" ").map { it.toInt() }
    val weight = readln().toInt()

    val index = indexOfFirstThreshold(n, s, weight)

    println(index)
}

fun indexOfFirstThreshold(n: Int, s: List<Int>, weight: Int): Int {
    var left = 0
    var right = s.size - 1
    var result = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (s[mid] >= weight) {
            result = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return result
}
