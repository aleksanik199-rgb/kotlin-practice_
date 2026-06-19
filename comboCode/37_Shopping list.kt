package comboCode

fun main() {
    val list = mutableListOf<String>()

    val items = addItems(list)
    if (!items) {
        println("Нет товаров")
        return
    }
    printItems(list)
}
fun addItems(list: MutableList<String>): Boolean{
    while(true){
        print("Введите название товара: ")
        var product = readln()
        if(product == "стоп")break
        list.add(product)
    }
    return list.isNotEmpty()
}

fun printItems(list: MutableList<String>) {
    println("Товары: ${list.joinToString(", ")}")
    println("Уникальные товары: ${list.distinct().size}")
}