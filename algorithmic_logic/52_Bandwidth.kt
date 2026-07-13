package algorithmic_logic

fun main() {
    val (n, t) = readln().trim().split(" ").map { it.toInt() }
    val sizes = readln().trim().split(" ").map { it.toInt() }

    var left = 1
    var right = sizes.max()
    var result = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (isFeasible(mid, sizes, t)) {
            result = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(result)
}

fun isFeasible(mid: Int, sizes: List<Int>, t: Int): Boolean {
    var total = 0

    for (size in sizes) {
        total += (size + mid - 1) / mid
    }
    return total <= t
}

