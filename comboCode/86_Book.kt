package comboCode

class BookItem(val title: String, val author: String) {
    init {
        println("init: $title от $author")
    }

    constructor(title: String) : this(title, "Неизвестен") {
        println("init: $title")
    }

}

fun main() {
    val book1 = BookItem("Война и мир", "Толстой")
    val book2 = BookItem("Мертвые души")
}