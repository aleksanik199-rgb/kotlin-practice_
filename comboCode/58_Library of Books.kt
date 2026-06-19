package comboCode


fun main() {
    val book = mutableMapOf<String, Int>()

    while (addBook(book)) {
    }

    println("Количество фильмов: ${book.size}")

    if (book.isNotEmpty()){
        val longBook = findLongestBook(book)
        println("Самая большая книга: $longBook")
    } else {
        println("Нет книг")
    }

     val avg = averageNumberPages(book)
    println("Среднее колличество страниц: $avg")

    allBooks(book)
}
fun addBook(book: MutableMap<String, Int>): Boolean {

    print("Введите название: ")
    val name = readln()
    if (name == "стоп"){
        return false
    }
    print("Введите колличество страниц: ")
    val number = readln().toInt()
    book[name] = number
    return true
}

fun findLongestBook(book: MutableMap<String, Int>): Pair<String, Int> {
    var nameMax = " "
    var numberMax = 0
    for ((name, number) in book) {
        if (number > numberMax) {
            nameMax = name
            numberMax = number
        }
    }
    return Pair(nameMax, numberMax)
}

fun averageNumberPages(book: MutableMap<String, Int>): Double {
    return book.values.average()
}

fun allBooks(book: MutableMap<String, Int>) {
    for ((name, number) in book) {
        println("$name: $number")
    }
}

