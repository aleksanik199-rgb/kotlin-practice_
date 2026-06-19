package comboCode

fun main() {
    val shoppingList = mutableListOf<String>()
    var total = 0.0

    while(true) {
        println("1 — Добавить товар")
        println("2 — Показать чек")
        println("3 — Выйти")
        print("Выбор: ")

        val choice = readln().toInt()

        when (choice) {
            1 -> {
                print("Название товара: ")
                val name = readln()
                shoppingList.add(name)

                print("Цена: ")
                val price = readln().toDouble()
                total += price
                println("Товар $name добавлен")
            }
            2 -> {
                if (shoppingList.isEmpty()) {
                    println("Корзина пуста.")
                } else {
                    println("--- Чек ---")
                    for (item in shoppingList) {
                        println("Товар: $item")
                    }
                    println("Итого: $total руб.")
                }
            }
            3 -> {
                println("До свидания!")
                break

            }
            else -> {
                println("Неверный выбор. Попробуйте снова.")
            }
        }
    }
}