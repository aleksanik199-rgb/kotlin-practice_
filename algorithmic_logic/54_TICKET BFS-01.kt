package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val edges = input.drop(2).chunked(2).map { it[0] to it[1] }
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    val start = input[0]
    val target = input[1]
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()
    val distance = mutableMapOf<Int, Int>()

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
                distance[neighbor] = distance[node]!! + 1
                queue.addLast(neighbor)
            }
        }

    }
    val result = distance.getOrDefault(target, -1)

    println(result)
}

