package comboCode

fun main() {
    val login = readln()
    val password = readln()

    val access = checkAccess(login, password)

    if (access){
        println("Доступ разрешен")
    }else{
        println("Доступ запрещён")
    }
}

fun checkAccess(login: String, password: String): Boolean {
    return login == "admin" && password == "12345"
}