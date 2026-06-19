package comboCode

open class Vehicle(val brand: String, val year: Int, var speed: Double) {
    open fun accelerate(amount: Double) {
       speed = (speed + amount).coerceAtMost(200.0)
    }

    fun brake(amount: Double) {
        speed = (speed - amount).coerceAtLeast(0.0)
    }

    open fun info(): String {
        return "Бренд: $brand, Год: $year, Скорость: $speed"
    }
}

class Car: Vehicle("BMW", 2020, 0.0) {
    override fun info(): String {
        return super.info() + ", Дверей: 4"
    }

    fun drift(): String {
        return "Машина $brand дрифтует!"
    }
}

class Motorcycle: Vehicle("Yamaha", 2022, 0.0) {
    override fun accelerate(amount: Double) {
        speed = (speed + amount).coerceAtMost(150.0)
    }

    fun wheelie(): String {
        return "Мотоцикл $brand едет на заднем колесе!"
    }
}

fun main() {
    val car = Car()
    val motorcycle = Motorcycle()

    car.accelerate(180.0)
    println("Машина BMW: разгон до ${car.speed}")

    car.brake(120.0)
    println("Машина BMW: торможение до ${car.speed}")

    println(car.info())
    println(car.drift())
    println()

    motorcycle.accelerate(150.0)
    println("Мотоцикл Yamaha: разгон до ${motorcycle.speed}")

    motorcycle.brake(60.0)
    println("Мотоцикл Yamaha: торможение до ${motorcycle.speed}")

    println(motorcycle.info())
    println(motorcycle.wheelie())
}