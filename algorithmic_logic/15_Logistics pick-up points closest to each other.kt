package algorithmic_logic

fun main() {
    val locations = readln().trim().split(" ").map { it.toInt() }

    val distance = minDistance(locations)

    println(distance)
}

fun minDistance(locations: List<Int>): Int {
    val sorted = locations.sorted()

    var mindist: Int? = null

    for (i in 0 .. sorted.size - 2) {
        val diff = sorted[i + 1] - sorted[i]
        if (mindist == null || diff < mindist) {
            mindist = diff
        }
    }
    return mindist ?: 0
}