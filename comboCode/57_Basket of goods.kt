package comboCode

fun main() {
    val product = mutableMapOf<String, Int>()

    while(true) {
        println("1 — Добавить товар")
        println("2 — Удалить товар")
        println("3 — Показать корзину")
        println("4 — Выйти")

        print("Введите свой выбор: ")
        val choice = readln().toInt()
        when(choice) {
            1 -> {
                print("Введите название товара: ")
                var name = readln()
                print("Введите коллличество: ")
                val quantity = readln().toInt()
                if (product.containsKey(name)){
                    product[name] = product[name]!! + quantity
                    println("Товар $name обновлён: + $quantity шт")
                } else {
                    product[name] = quantity
                    println("Товар $name добавлен в количестве $quantity шт")
                }
            }
            2 -> {
                print("Введите название для удаления: ")
                val name = readln()
                if (product[name] != null) {
                    product.remove(name)
                    println("Товар $name удален")
                } else {
                    println("Товар не найден")
                }
            }
            3 -> {
                for ((name, quantity) in product) {
                    println("Товар $name: $quantity шт")
                }
            }
            4 -> {
                println("До свидания!")
                break
            }
            else -> println("Ошибка!")
        }
    }
}