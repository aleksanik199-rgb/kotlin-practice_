package comboCode

fun main() {
    val quantityProduct = readln().toInt()
    var total = 0.0

    for(i in 1..quantityProduct) {
        print("Цена товара $i: ")
        val price = readln().toDouble()
        total += price
    }
    val average = total / quantityProduct
    println("Средняя цена: $average")
}