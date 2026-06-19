package comboCode

fun main() {
    val material = "Кирпич"
    val priceOne = 12.5
    val quantity = 250
    val availabilityDiscount = true

    val total = priceOne * quantity
    val discount = if (availabilityDiscount == true) 10 else 0
    val sumDiscount = total - (total * discount / 100)

    println("Материал: $material")
    println("Цена за шт: $priceOne руб")
    println("Количество: $quantity шт")
    println("Скидка: $discount")
    println("Общая стоимость: $total руб")
    println("Итого: $sumDiscount руб")
}