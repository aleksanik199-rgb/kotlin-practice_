package comboCode

abstract class Vehicles(val brand: String, val year: Int) {
    abstract fun move(): String
    abstract fun fuelType(): String

    fun info(): String {
        return "Бренд: $brand, Год: $year"
    }
}

open class Cars(brand: String, year: Int, val doors: Int): Vehicles(brand, year) {
    override fun move(): String = "Машина $brand едет по дороге"
    override fun fuelType(): String = "Бензин"
}

class ElectricCar(brand: String, year: Int, doors: Int): Cars(brand, year, doors){
    override fun fuelType(): String = "Электричество"
}

class Bicycles(brand: String, year: Int): Vehicles(brand, year){
    override fun move(): String = "Велосипед $brand едет по велодорожке"
    override fun fuelType(): String = "Мышечная сила"
}

fun main() {
    val vehicles: List<Vehicles> = listOf(
        Cars("BMW", 2026, 4 ),
        ElectricCar("Mercedes-Benz", 2025, 4),
        Bicycles("Steels", 2017)
    )

    for (vehicle in vehicles) {
        println(vehicle.info())
        println(vehicle.move())
        println(vehicle.fuelType())
        println()
    }
}