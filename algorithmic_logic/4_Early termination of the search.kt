package algorithmic_logic

fun main() {
    val diagnostics = readln().trim().split(" ").map { it.toInt() }

    val error = diagnosticErrors(diagnostics)
    println(error)
}

fun diagnosticErrors(diagnostics: List<Int>): Boolean {
    for (diagnostic in diagnostics) {
        if (diagnostic != 0) {
            return false
        }
    }
    return true
}