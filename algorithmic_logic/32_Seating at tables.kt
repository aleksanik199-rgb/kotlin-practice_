package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, x, s) = readln().trim().split(" ").map { it.toInt() }
        val u = readln()

        val countA = u.count() {it == 'A'}
        var best = 0
        for (k in 0..countA) {
            val result = seatingOfGuests(n, x, s, u, k)
            best = maxOf(best, result)
        }
        println(best)
    }
}

fun seatingOfGuests(n: Int, x: Int, s: Int, u: String, k: Int): Int {
    var ambiverts = 0
    var opened = 0
    var seated = 0

    for (person in u) {
        when (person) {
            'I' -> if (opened < x) {opened++; seated++}
            'E' -> if (seated < opened * s) {seated++}
            'A' -> {
                ambiverts++
                if (ambiverts <= k) {
                    if (opened < x) {opened++; seated++}
                } else {
                    if (seated < opened * s) {seated++}
                }
            }
        }
    }
    return seated
}


