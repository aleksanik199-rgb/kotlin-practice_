package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val s = readln()

        val count = countDistinctStrings(n, s)

        println(count)
    }
}
fun countDistinctStrings(n: Int, s: String): Int {
    var count = 0
    for (i in 0..n - 3) {
        if (s[i] == s[i + 2]) {
            count++
        }
    }
    val result = (n - 1) - count
    return result
}