package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }

        val minLargest = minLargestPile(n, a)

        println(minLargest)
    }
}

fun minLargestPile(n: Int, a: List<Long>): Long {
    val stack = mutableListOf<Long>()

    for (element in a) {
        var current = element
        while (stack.isNotEmpty() && stack.last() > current) {
            current += stack.removeAt(stack.size - 1)
        }
        stack.add(current)
    }
    return stack.last()
}