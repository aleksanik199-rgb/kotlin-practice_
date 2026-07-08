package algorithmic_logic

data class TrafficQuery(val l: Int, val r: Int)

fun main() {
    val hourlyTraffic = readln().trim().split(" ").map { it.toLong() }
    val input = readln().trim().split(" ").map { it.toInt() }
    val query = input.chunked(2).map { TrafficQuery(it[0], it[1]) }

    val trafficSum = batchTrafficSum(hourlyTraffic, query)
    println(trafficSum)
}

fun batchTrafficSum(hourlyTraffic: List<Long>, query: List<TrafficQuery>): List<Long>  {
    val list = mutableListOf<Long>()
    val n = hourlyTraffic.size
    val prefix = LongArray(n + 1)
    for (i in 1..n) {
        prefix[i] = prefix[i - 1] + hourlyTraffic[i - 1]
    }
    for (q in query) {
        val sum = prefix[q.r + 1] - prefix[q.l]
        list.add(sum)
    }

    return list
}