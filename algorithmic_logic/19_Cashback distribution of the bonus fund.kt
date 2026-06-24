package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val applications = input.chunked(2).map { it[0] to it[1] }
    val budget = readln().toInt()

    val select = selectApplications(applications, budget)

    println(select)
}

fun selectApplications(applications: List<Pair<Int, Int>>, budget: Int): Int {
    val sorted = applications.sortedByDescending { it.second.toDouble() / it.first }
    var remaining = budget
    var totalRating = 0

    for ((bonus, rating) in sorted) {
        if (bonus <= remaining ) {
            remaining -= bonus
            totalRating += rating
        }
    }
    return totalRating
}