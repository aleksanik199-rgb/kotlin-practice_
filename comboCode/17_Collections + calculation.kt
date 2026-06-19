package comboCode

fun main() {
    val prices = listOf(120.0, 350.0, 80.0, 550.0, 230.0)
    println("Цены:")

    for (price in prices) {
        println(price)
    }
    println("Сумма:")
    println(prices.sum())
    println("Средняя:")
    println(prices.average())
    println("Максимальная:")
    println(prices.maxOf{it})
}