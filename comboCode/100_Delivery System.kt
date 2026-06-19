package comboCode

abstract class Delivery(val orderId: String, val weightKg: Double, val distanceKm: Double) {
    init {
        require(weightKg > 0) {"Вес не может быть 0"}
        require(distanceKm > 0) {"Расстояние не может быть 0"}
        require(orderId.isNotEmpty()) {"Значение не может быть пустым"}
    }

    abstract fun calculateCost(): Double

    fun receipt(): String {
        return "${this::class.simpleName}: заказ $orderId, вес $weightKg кг, расстояние $distanceKm км, стоимость ${calculateCost()} руб "
    }
}

class CourierDelivery(orderId: String, weightKg: Double, distanceKm: Double, val isExpress: Boolean): Delivery(orderId, weightKg, distanceKm) {
    override fun calculateCost(): Double {
        if (!isExpress) {
            return weightKg * 50 + distanceKm * 10
        } else {
            return (weightKg * 50 + distanceKm * 10) * 1.5
        }
    }
}

class PickupPointDelivery(orderId: String, weightKg: Double, distanceKm: Double, val storageFeeDays: Int): Delivery(orderId, weightKg, distanceKm) {
    override fun calculateCost(): Double {
        return weightKg * 30 + storageFeeDays * 20
    }
}

class DroneDelivery(orderId: String, weightKg: Double, distanceKm: Double): Delivery(orderId, weightKg, distanceKm) {
    init {
        require(weightKg <= 3.0) {"Вес должен быть не более 3 кг"}
    }

    override fun calculateCost(): Double {
        return distanceKm * 25
    }
}

fun main() {
    val deliveries: List<Delivery> = listOf(
        CourierDelivery("674967", 15.0, 30.0, true),
        PickupPointDelivery("7685768", 30.0, 10.0, 5),
        DroneDelivery("8796889", 2.0, 14.0)
    )

    for (delivery in deliveries) {
        println(delivery.receipt())
        println()
    }

    val total = deliveries.sumOf { it.calculateCost() }
    println("Общая стоимость: $total")
}