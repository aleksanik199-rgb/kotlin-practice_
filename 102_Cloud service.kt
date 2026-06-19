package algorithmic_logic

fun main() {
    val (f, p, s) = readln().trim().split(" ").map { it.toInt() }
    println(if (s <= f) 0 else (s - f) * p)
}