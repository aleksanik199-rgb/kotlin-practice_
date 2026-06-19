package comboCode

fun main() {
    val prices = listOf(150.0, 250.0, 100.0, 300.0, 200.0)
    var total = 0.0

    for (price in prices){
        total += price
    }
    val average = prices.average()
    println("Средняя цена: $average руб")
}