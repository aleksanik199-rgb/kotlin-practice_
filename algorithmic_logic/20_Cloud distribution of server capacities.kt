package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val processes = input.chunked(2).map { it[0] to it[1] }
    val availableHours = readln().toInt()

    val select = selectProcesses(processes, availableHours)

    println(select)
}

fun selectProcesses(processes: List<Pair<Int, Int>>, availableHours: Int): Int {
    val sortedProcesses = processes.sortedBy { it.first }
    var limitHours = availableHours
    var total = 0

    for ((duration, priority) in sortedProcesses) {
        if (duration <= limitHours) {
            limitHours -= duration
            total++
        } else {
            break
        }
    }
    return total
}