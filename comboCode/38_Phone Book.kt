package comboCode

fun main() {
    val phoneBook  = mutableMapOf<String, String>()

    while (true){
        printMenu()

        val choice = readln().toInt()
        when (choice) {
            1 -> addContact(phoneBook)
            2 -> findContact(phoneBook)
            3 -> {
                println("До свидания!")
                break
            }
            else -> println("Ошибка, попробуйте еще раз!")
        }
    }
}

fun printMenu() {
    println("1 — Добавить контакт")
    println("2 — Найти контакт")
    println("3 — Выйти")
    print("Выбор: ")
}
fun addContact(phoneBook: MutableMap<String, String>) {
    print("Введите имя: ")
    val name = readln()
    if (name.isBlank()){
        println("Значение не может быть пустым")
        return
    }
    print("Введите номер: ")
    val phone = readln()
    phoneBook[name] = phone
    println("Контакт добавлен!")
}
fun findContact(phoneBook: Map<String, String>) {
    print("Введите имя: ")
    val name = readln()
    if (name.isBlank()) {
        println("Имя не может быть пустым")
        return
    }
    val number = phoneBook[name]
    if (number != null){
        println("Номер: $number")
    }else{
        println("Контакт не найден")
    }
}