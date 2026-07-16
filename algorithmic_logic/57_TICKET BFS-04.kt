package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val k = input[0]
    val sources = input.drop(1).take(k)
    val edges = input.drop(1 + k).chunked(2).map { it[0] to it[1] }
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()
    val distance = mutableMapOf<Int, Int>()

    for ((a, b) in edges) {
        adjacencyList.getOrPut(a) { mutableListOf() }.add(b)
        adjacencyList.getOrPut(b) { mutableListOf() }.add(a)
    }

    for (source in sources) {
        visited.add(source)
        distance[source] = 0
        queue.addLast(source)
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

    val allNodes = adjacencyList.keys
    val result = if (allNodes.all { it in distance }) distance.values.max() else -1
    println(result)
}