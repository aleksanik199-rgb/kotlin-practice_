package algorithmic_logic

fun main() {
    val amounts = readln().trim().split(" ").map { it.toInt() }
    val limit = readln().toInt()

    val hasSuspicious = hasSuspiciousTransaction(amounts, limit)

    println(hasSuspicious)
}

fun hasSuspiciousTransaction(amounts: List<Int>, limit: Int): Boolean {
    for (amount in amounts) {
        if (amount > limit) return true
    }
    return false
}