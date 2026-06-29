package algorithmic_logic

data class Task(val duration: Int, val deadline: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val tasks = input.chunked(2).map { Task(it[0], it[1]) }

    val maxTasks = maxCompletedTasks(tasks)

    println(maxTasks)
}

fun maxCompletedTasks(tasks: List<Task>): Int {
    val sorted = tasks.sortedBy { it.deadline }
    var count = 0
    var currentTime = 0

    for (task in sorted) {
        if (currentTime + task.duration <= task.deadline) {
            currentTime += task.duration
            count++
        }
    }
    return count
}