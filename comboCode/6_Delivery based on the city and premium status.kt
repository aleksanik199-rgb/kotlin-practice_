package comboCode

fun main() {
    val orderAmount = readln().toDouble()
    val city = readln()
    val premiumStatus = readln()
    val numberProducts = readln().toInt()

    val delivery = deliveryPrice(city)
    val discountPercent = premiumDiscount(premiumStatus)
    val discount = orderAmount * discountPercent / 100
    val total = (orderAmount - discount) + delivery

    printOrder(orderAmount, city, premiumStatus, numberProducts, total)
}

fun deliveryPrice(city: String): Int {
    return when (city) {
        "Москва" -> 300
        "СПб" -> 400
        else -> 600
    }
}

fun premiumDiscount(premiumStatus: String): Int{
    return if (premiumStatus == "да") 10 else 0
}

fun printOrder(orderAmount: Double, city: String, premiumStatus: String, numberProducts: Int, total: Double) {
    println("Сумма заказа: $orderAmount")
    println("Город: $city")
    println("Премиум: $premiumStatus")
    println("Количество товаров: $numberProducts")
    println("Итого к оплате: $total")
}
