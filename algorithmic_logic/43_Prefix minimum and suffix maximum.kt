package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().trim().split(" ").map { it.toInt() }

        val indices = prefixSuffix(n, a)

        println(indices)
    }
}

fun prefixSuffix(n: Int, a: List<Int>): String {
    val prefixMin = IntArray(a.size + 1)
    val suffixMax = IntArray(a.size + 1)
    var currentMin = a[0]
    var currentMax = a[n - 1]

    for (i in a.indices) {
        currentMin = minOf(currentMin, a[i])
        prefixMin[i] += currentMin
    }
    for (i in n-1 downTo 0) {
        currentMax = maxOf(currentMax, a[i])
        suffixMax[i] += currentMax
    }
    val result = StringBuilder()
    for (i in a.indices) {
        if (a[i] == prefixMin[i] || a[i] == suffixMax[i]) {
            result.append('1')
        } else {
            result.append('0')
        }
    }
    return result.toString()
}