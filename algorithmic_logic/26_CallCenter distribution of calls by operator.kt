package algorithmic_logic

data class Call(val arrivalTime: Int, val duration: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val calls = input.chunked(2).map { Call(it[0], it[1]) }
    val operatorCount = readln().toInt()

    val maxAccepted = maxAcceptedCalls(calls, operatorCount)

    println(maxAccepted)
}

fun maxAcceptedCalls(calls: List<Call>, operatorCount: Int): Int {
    val freeAt = MutableList(operatorCount) { 0 }
    var maxAccepted = 0

    for (call in calls) {
        var bestCallIndices = -1
        var bestCall = Int.MAX_VALUE

        for (i in freeAt.indices) {
            if (freeAt[i] <= call.arrivalTime ) {
                if (bestCallIndices == -1 || freeAt[i] < bestCall) {
                    bestCallIndices = i
                    bestCall = freeAt[i]
                }
            }
        }
        if (bestCallIndices != -1) {
            freeAt[bestCallIndices] = call.arrivalTime + call.duration
            maxAccepted++
        }
    }
    return maxAccepted
}