package algorithmic_logic

fun main() {
    val (rows, cols) = readln().trim().split(" ").map { it.toInt() }
    val grid = Array(rows) { readln().trim().split(" ").map { it.toInt() }.toIntArray() }
    val (targetRow, targetCol) = readln().trim().split(" ").map { it.toInt() }
    val startRow = 0
    val startCol = 0
    val directions = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
    val dist = Array(rows) { IntArray(cols) { -1 } }
    val queue = ArrayDeque<Pair<Int, Int>>()

    dist[startRow][startCol] = 0
    queue.addLast(startRow to startCol)

    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()
        for ((dr, dc) in directions) {
            val newRow = row + dr
            val newCol = col + dc
            val inBounds = newRow in 0 until rows && newCol in 0 until cols
            if (inBounds && dist[newRow][newCol] == -1 && grid[newRow][newCol] == 0) {
                dist[newRow][newCol] = dist[row][col] + 1
                queue.addLast(newRow to newCol)
            }
        }
    }
    val result = dist[targetRow][targetCol]
    println(result)
}