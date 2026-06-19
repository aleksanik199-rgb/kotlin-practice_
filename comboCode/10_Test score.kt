package comboCode

fun main() {
    val points = 60
    val maxPoints = 100

    val percent = (points.toDouble() / maxPoints) * 100
    val estimation = pointsPercent(percent)

    println("Баллы: $points / $maxPoints")
    println("Процент: $percent%")
    println("Оценка: $estimation")
}

fun pointsPercent(percent: Double): String {
    return when (percent) {
        in 90.0..100.0 -> "Отлично"
        in 70.0..89.0 -> "Хорошо"
        in 50.0..69.0 -> "Удовлетворительно"
        in 30.0..49.0 -> "Плохо"
        else -> "Провал"
    }
}