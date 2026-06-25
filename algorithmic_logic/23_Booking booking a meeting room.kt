package algorithmic_logic

data class Meeting(val start: Int, val end: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val meetings = input.chunked(2).map { Meeting(it[0], it[1]) }

    val max = maxMeetings(meetings)

    println(max)
}

fun maxMeetings(meetings: List<Meeting>): Int {
    val sorted = meetings.sortedBy { it.end }
    var count = 0
    var lastEnd = Int.MIN_VALUE

    for (meeting in sorted) {
        if (meeting.start >= lastEnd) {
            count++
            lastEnd = meeting.end
        }
    }
    return count
}