package comboCode1

data class Application(val bonus: Int, val rating: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val applications = input.chunked(2).map { Application(it[0], it[1]) }
    val budget = readln().toInt()

    val select = selectApplication(applications, budget)

    println(select)
}

fun selectApplication(applications: List<Application>, budget: Int): Int {
    val sorted = applications.sortedByDescending { it.rating.toDouble() / it.bonus }
    var remaining = budget
    var totalRating = 0

    for (app in sorted) {
        if (app.bonus <= remaining) {
            remaining -= app.bonus
            totalRating += app.rating
        }
    }
    return totalRating
}