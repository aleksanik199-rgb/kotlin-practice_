package algorithmic_logic

fun main() {
    val watchedMinutes = readln().trim().split(" ").map { it.toInt() }
    val targetMinutes = readln().toInt()

    val episodes = necessaryEpisodes(watchedMinutes, targetMinutes)

    println(episodes)
}

fun necessaryEpisodes(watchedMinutes: List<Int>, targetMinutes: Int): Boolean {
    val seen = mutableSetOf<Int>()

    for (x in watchedMinutes) {
        val complement = targetMinutes - x
        if (complement in seen) {
            return true
        }
        seen.add(x)
    }
    return false
}