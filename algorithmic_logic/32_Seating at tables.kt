package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, x, s) = readln().trim().split(" ").map { it.toInt() }
        val u = readln()

        val seatedCount = seatingOfGuests(n, x, s, u)

        println(seatedCount)
    }
}

fun seatingOfGuests(n: Int, x: Int, s: Int, u: String): Int {
    val tables = MutableList(x) { 0 }
    var count = 0
    var remainingIntroverts = u.count { it == 'I' }

    for (person in u) {
        when (person) {
            'I' -> {
                val idx = tables.indexOfFirst { it == 0 }
                if (idx != -1) {
                    tables[idx] = 1
                    count++
                }
                remainingIntroverts--
            }

            'E' -> {
                val idx = tables.indexOfFirst { it in 1 until s }
                if (idx != -1) {
                    tables[idx]++
                    count++
                }
            }

            'A' -> {
                if (remainingIntroverts > 0) {
                    val idxNonEmpty = tables.indexOfFirst { it in 1 until s }
                    if (idxNonEmpty != -1) {
                        tables[idxNonEmpty]++
                        count++
                    } else {
                        val idxEmpty = tables.indexOfFirst { it == 0 }
                        if (idxEmpty != -1) {
                            tables[idxEmpty] = 1
                            count++
                        }
                    }
                } else {
                    val idxEmpty = tables.indexOfFirst { it == 0 }
                    if (idxEmpty != -1) {
                        tables[idxEmpty]++
                        count++
                    } else {
                        val idxEmpty = tables.indexOfFirst { it in 1 until s }
                        if (idxEmpty != -1) {
                            tables[idxEmpty]++
                            count++
                        }
                    }
                }
            }
        }
    }
    return count
}



