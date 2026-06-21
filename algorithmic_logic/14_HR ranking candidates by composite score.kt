package algorithmic_logic

fun main() {
    val testScores = readln().trim().split(" ").map { it.toInt() }
    val interviewScores = readln().trim().split(" ").map { it.toInt() }

    val sorting = sortingOfCandidates(testScores, interviewScores)

    println(sorting)
}

fun sortingOfCandidates(testScores: List<Int>, interviewScores: List<Int>): List<Int> {
    val totalScores = testScores.indices.map { index -> testScores[index] * 2 + interviewScores[index] }
    return totalScores.indices.sortedByDescending { index -> testScores[index] }
}