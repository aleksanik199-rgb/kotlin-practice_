package algorithmic_logic

fun main() {
    val dailyFreeLimitMinutes = readln().toInt()
    val watchedMinutesPerDays = readln().trim().split(" ").map { it.toInt() }

    val daysCount = daysExceedingLimit(dailyFreeLimitMinutes, watchedMinutesPerDays)

    println(daysCount)
}

fun daysExceedingLimit(dailyFreeLimitMinutes: Int, watchedMinutesPerDays: List<Int>): Int {
    var count = 0
    for (watchedMinutesPerDay in watchedMinutesPerDays) {
        if (watchedMinutesPerDay > dailyFreeLimitMinutes) {
            count++
        }
    }
    return count
}