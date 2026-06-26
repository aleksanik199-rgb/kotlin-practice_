package algorithmic_logic

data class Meeting(val start: Int, val end: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val meetings = input.chunked(2).map { Meeting(it[0], it[1]) }
    val roomCount = readln().toInt()

    val maxApproved = maxApprovedMeetings(meetings, roomCount)

    println(maxApproved)
}

fun maxApprovedMeetings(meetings: List<Meeting>, roomCount: Int): Int {
    val sortedMeetings = meetings.sortedBy { it.end }
    val lastEnds = MutableList(roomCount) { Int.MIN_VALUE }
    var countApproved = 0

    for (meeting in sortedMeetings) {
        var bestRoomIndex = -1
        var bestLastEnd = Int.MIN_VALUE

        for (i in lastEnds.indices) {
            if (lastEnds[i] <= meeting.start) {
                if (bestRoomIndex == -1 || lastEnds[i] > bestLastEnd) {
                    bestRoomIndex = i
                    bestLastEnd = lastEnds[i]

                }
            }
        }
        if (bestRoomIndex != -1) {
            lastEnds[bestRoomIndex] = meeting.end
            countApproved++
        }

    }
    return countApproved
}