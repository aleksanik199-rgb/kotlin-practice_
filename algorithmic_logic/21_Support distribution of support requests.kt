package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val requests = input.chunked(2).map { it[0] to it[1] }
    val workShift = readln().toInt()

    val supportRequests = handleSupportRequests(requests, workShift)

    println(supportRequests)
}

fun handleSupportRequests(requests: List<Pair<Int, Int>>, workShift: Int): Int {
    val sortedRequests = requests.sortedByDescending { it.second.toDouble() / it.first }
    var restOfShift = workShift
    var totalUrgency = 0

    for ((responseTime, urgency) in sortedRequests) {
        if (responseTime <= restOfShift) {
            restOfShift -= responseTime
            totalUrgency += urgency
        }
    }
    return totalUrgency
}