package comboCode

class Book(val title: String, val author: String, val year: Int) {

    fun info(): String {
        return "Название: $title, Автор: $author, Год: $year"
    }
}

fun main() {
    val book = Book("Война и мир", "Толстой", 1869)
    val book2 = Book("Идиот", "Достоевский", 1867)
    println(book.info())
    println(book2.info())
}