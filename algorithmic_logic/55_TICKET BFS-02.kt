package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val edges = input.drop(1).chunked(2).map { it[0] to it[1] }
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()
    val distance = mutableMapOf<Int, Int>()
    val start = input[0]

    queue.addLast(start); visited.add(start); distance[start] = 0

    for ((a, b) in edges) {
        adjacencyList.getOrPut(a) { mutableListOf() }.add(b)
        adjacencyList.getOrPut(b) { mutableListOf() }.add(a)
    }

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        for (neighbor in adjacencyList[node].orEmpty()) {
            if (neighbor !in visited) {
                visited.add(neighbor)
                queue.addLast(neighbor)
                distance[neighbor] = distance[node]!! + 1

            }
        }
    }
    val result = distance.filterValues { it == 2 }.keys.sorted()
    println(result)
}