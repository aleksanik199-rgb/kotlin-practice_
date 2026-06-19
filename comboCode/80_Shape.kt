package comboCode

abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
    abstract fun info(): String
}

class Rectangle(val width: Double, val height: Double): Shape() {
    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
    override fun info(): String = "Прямоугольник $width x $height"
}

class Circle(val radius: Double): Shape() {
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
    override fun info(): String = "Круг с радиусом $radius"
}

fun main() {
    val shapes: List<Shape> = listOf(
        Rectangle(5.0, 5.0),
        Circle(5.0),
    )

    for (shape in shapes) {
        println(shape.info())
        println("Площадь: ${shape.area()}")
        println("Периметр: ${shape.perimeter()}")
        println()
    }
}