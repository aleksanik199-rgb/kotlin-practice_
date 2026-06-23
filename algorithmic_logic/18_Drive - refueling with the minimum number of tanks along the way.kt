package algorithmic_logic

fun main() {
    val drives = readln().trim().split(" ").map { it.toInt() }
    val tankRange = readln().toInt()

    val minDrive = minimumDrive(drives, tankRange)

    println(minDrive)
}

fun minimumDrive(drives: List<Int>, tankRange: Int): Int {
    var currentPos = 0
    var count = 0
    var prevStation = 0

    for (station in drives) {
        if (station - currentPos > tankRange) {
            count++
            currentPos = prevStation
        }
        prevStation = station
    }
    val finish = drives.last()
    if (finish - currentPos > tankRange) {
        count++
    }
    return count
}