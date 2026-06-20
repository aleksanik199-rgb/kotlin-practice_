package algorithmic_logic

fun main() {
    val emails = readln().trim().split(" ")

    val duplicate = duplicateEmail(emails)

    println(duplicate)
}

fun duplicateEmail(emails: List<String>): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()

    for (i in emails.indices) {
        for (j in emails.indices) {
            if (i < j && emails[i] == emails[j]) {
                pairs.add(Pair(i, j))
            }
        }
    }
    return pairs
}