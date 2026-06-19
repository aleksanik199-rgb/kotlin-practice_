package comboCode

fun main() {
    val temperatures = listOf(22.5, 23.0, 21.5, 24.0, 22.0)

    val average = averageTemperature(temperatures)

    println("Средняя температура: $average")
}

fun averageTemperature(temperatures: List<Double>): Double {
    if (temperatures.isEmpty()) return Double.NaN

    var sum = 0.0
    for (temp in temperatures) {
        sum += temp
    }
    return sum / temperatures.size
}