package comboCode

class Circles(var radius: Double) {
    var diameter: Double = 0.0
        get() = radius * 2.0
        set(value) {
            radius = value / 2.0
            field = value
        }
}

fun main() {
    val circles = Circles(7.0)
    circles.diameter = 5.0
    println(circles.radius)
}