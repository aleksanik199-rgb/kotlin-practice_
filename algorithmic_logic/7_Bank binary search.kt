package algorithmic_logic

fun main() {
    val applicationId = readln().toInt()
    val approvedLoans = readln().trim().split(" ").map { it.toInt() }

    val approved = approvedApplicationsByIdentifier(approvedLoans, applicationId)

    println(approved)
}

fun approvedApplicationsByIdentifier(approvedLoans: List<Int>, applicationId: Int): Boolean {
    var left = 0
    var right = approvedLoans.size - 1

    while (left <= right) {
        val middle = (left + right) / 2
        when {
            approvedLoans[middle] == applicationId -> return true
            approvedLoans[middle] < applicationId -> left = middle + 1
            else -> right = middle - 1
        }
    }
    return false
}