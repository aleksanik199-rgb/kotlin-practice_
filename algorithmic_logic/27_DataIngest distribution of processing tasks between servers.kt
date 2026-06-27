package algorithmic_logic

data class DataTask(val arrivalTime: Int, val dataSize: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val tasks = input.chunked(2).map { DataTask(it[0], it[1]) }
    val serverCount = readln().toInt()

    val maxAccepted = maxAcceptedTasks(tasks, serverCount)

    println(maxAccepted)
}

fun maxAcceptedTasks(tasks: List<DataTask>, serverCount: Int): Int {
    val freeAt = MutableList(serverCount) { 0 }
    var countAdopted = 0

    for (task in tasks) {
        var bestTaskIndices = -1
        var bestTask = Int.MAX_VALUE

        for (i in freeAt.indices) {
            if (freeAt[i] <= task.arrivalTime) {
                if (bestTaskIndices == -1 || freeAt[i] < bestTask) {
                    bestTaskIndices = i
                    bestTask = freeAt[i]
                }
            }
        }
        if (bestTaskIndices != -1) {
            freeAt[bestTaskIndices] = task.arrivalTime + task.dataSize
            countAdopted++
        }
    }
    return countAdopted
}