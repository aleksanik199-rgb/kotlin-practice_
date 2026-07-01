package algorithmic_logic

fun main() {
    val stations = readln().trim().split(" ").map { it.toInt() }
    val tankRange = readln().toInt()
    val destination = readln().toInt()

    val refuels = minRefuels(stations, tankRange, destination)

    println(refuels)
}

fun minRefuels(stations: List<Int>, tankRange: Int, destination: Int): Int {
    var maxReach = tankRange
    var lastReachable = 0
    var count = 0

    for (station in stations) {
        if (station <= maxReach) {
            lastReachable = station
        } else {
            maxReach = lastReachable + tankRange
            count++
        }

        if (station > maxReach) {
            return -1
        }
         lastReachable = station
    }
    if (maxReach >= destination) {
        return count
    } else {
        maxReach = lastReachable + tankRange
        count++
    }
    
    if (maxReach >= destination) {
        return count
    } else {
        return -1
    }
}