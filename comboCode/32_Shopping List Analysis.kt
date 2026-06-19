package comboCode

import kotlin.collections.mutableMapOf

fun main() {
    val shopping  = mutableMapOf<String, Double>()

    while (true) {
        print("Введите название: ")
        val name = readln()
        if (name.isEmpty()) break
        print("Введите цену: ")
        val price = readln().toDouble()
        shopping[name] = price
    }
    if (shopping.isEmpty()){
        println("Нет товаров")
        return
    }
    var total = 0.0
    var maxPrice = 0.0
    var maxName = ""

    for ((name, price) in shopping){
        total += price
        if (price > maxPrice){
            maxPrice = price
            maxName = name
        }
    }
    println("Общая стоимость: $total")
    println("Средняя цена: ${total / shopping.size}")
    println("Самый дорогой товар: $maxName ($maxPrice руб)")
}