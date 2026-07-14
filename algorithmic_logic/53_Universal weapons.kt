package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, h, k) = readln().trim().split(" ").map { it.toInt() }
        val a = readln().trim().split(" ").map { it.toInt() }
        val s = a.sumOf { it.toLong() }
        val m = (h - 1) / s
        val rem = h - m * s
        val prefix = LongArray(n + 1)
        val prefixMin = LongArray(n + 1)
        val suffixMax = LongArray(n + 2)

        prefix[0] = 0
        for (i in 1..n) {
            prefix[i] = prefix[i - 1] + a[i -1]
        }
        prefixMin[1] = a[0].toLong()
        for (i in 2 .. n) {
            prefixMin[i] = minOf(prefixMin[i - 1], a[i - 1].toLong())
        }
        suffixMax[n + 1] = 0
        for (i in n downTo 1) {
            suffixMax[i] = maxOf(a[i - 1].toLong(), suffixMax[i + 1])
        }
        var left = 1
        var right = n
        var r = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (best(mid, prefix, prefixMin, suffixMax)  >= rem) {
                r = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        val answer = m * (n + k) + r
        println(answer)

    }
}

fun best(r: Int, prefix: LongArray, prefixMin: LongArray, suffixMax: LongArray): Long {
    return prefix[r] + maxOf(0L, suffixMax[r + 1] - prefixMin[r])
}

