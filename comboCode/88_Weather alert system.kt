package comboCode

import comboCode.WeatherAlert

abstract class WeatherAlert(val temperature: Double, val windSpeed: Double) {
    abstract fun getAlertMessage(): String

    fun isSevere(): Boolean = windSpeed > 50 || temperature < -30 || temperature > 35

    init {
        require(windSpeed >= 0) { "Скорость ветра не может быть отрицательной" }
        require(temperature >= -273.15) { "Температура ниже абсолютного нуля невозможна" }
    }
}

class StormAlert (temperature: Double, windSpeed: Double, val stormType: String) : WeatherAlert(temperature, windSpeed) {
    override fun getAlertMessage(): String {
        return "ШТОРМ ($stormType)! Ветер $windSpeed км/ч. Температура $temperature°C"
    }
}

class YellowAlert (temperature: Double, windSpeed: Double) : WeatherAlert(temperature, windSpeed) {
    override fun getAlertMessage(): String {
        return "ЖЁЛТЫЙ УРОВЕНЬ: Ветер $windSpeed км/ч, температура $temperature°C. Будьте осторожны!"
    }
}

class RegularForecast (temperature: Double, windSpeed: Double) : WeatherAlert(temperature, windSpeed) {
    constructor(temperature: Double) : this(temperature, 0.0)

    override fun getAlertMessage(): String {
        return "Прогноз: $temperature°C, ветер $windSpeed км/ч. Спокойной погоды."
    }
}

fun main() {
    val alerts: List<WeatherAlert> = listOf(
        StormAlert(25.4,75.0, "Тайфун"),
        YellowAlert(35.0, 40.0),
        RegularForecast(30.0)
    )

    for (alert in alerts) {
        println(alert.getAlertMessage())
        println(alert.isSevere())
        println()
    }
}