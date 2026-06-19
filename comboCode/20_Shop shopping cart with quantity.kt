package comboCode

fun main() {
    val product = mutableMapOf<String, Int>()

    println("1 — Добавить товар")
    println("2 — Удалить товар")
    println("3 — Показать корзину")
    println("4 — Выйти")

    while(true) {
        val choice = readln().toInt()

        when (choice) {
            1 -> {
                print("Введите название: ")
                val name = readln()

                print("Введите колличество: ")
                val quantity = readln().toInt()

                if (product.containsKey(name)) {
                    product[name] = product[name]!! + quantity
                }else{
                    product[name] = quantity
                }
            }
            2 -> {
                print("Введите название: ")
                val name = readln()

                if (product.containsKey(name)) {
                    product.remove(name)
                }else{
                    println("Товар не найден")
                }
            }
            3 -> {
                if (product.isEmpty()){
                    println("Корзина пуста")
                }else{
                    println("---Чек---")
                    for ((name, quantity) in product){
                        println("$name: $quantity шт")
                    }
                }
            }
            4 -> {
                println("Выход")
                break
            }
            else -> println("Ошибка")
        }
    }
}