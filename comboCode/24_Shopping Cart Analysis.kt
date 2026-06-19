package comboCode

fun main() {
    val product = mutableMapOf<String, Double>()

    while (addItem(product)) {
    }

    print("Введите лимит: ")
    val userLimit = readln().toDouble()

    println("Товары в лимите:")
    showCheapItems(product, userLimit)

    println("Товары выше лимита:")
    showExpensiveItems(product, userLimit)
}

fun addItem(product: MutableMap<String, Double>): Boolean{
    print("Название товара (или 'стоп'):")
    val name = readln()
    if (name == "стоп") {
        return false
    }

    print("Цена:")
    val price = readln().toDouble()
    product[name] = price
    return true
}

fun showCheapItems(product: MutableMap<String, Double>, userLimit: Double){
    for ((name, price) in product) {
        if (price <= userLimit) {
            println("$name, $price")
        }
    }
}

fun showExpensiveItems(product: MutableMap<String, Double>, userLimit: Double){
    for ((name, price) in product) {
        if (price > userLimit) {
            println("$name, $price")
        }
    }
}
