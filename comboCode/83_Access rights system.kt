package comboCode

abstract class AccessLevel(val name: String) {
    abstract fun getPermissions(): List<String>
    abstract fun canRead(): Boolean
    abstract fun canWrite(): Boolean
    abstract fun canDelete(): Boolean
    fun info(): String {
        return "Пользователь $name ${getPermissions()}"
    }
}

class Guest(name: String): AccessLevel(name) {
    override fun canRead(): Boolean = true
    override fun canWrite(): Boolean = false
    override fun canDelete(): Boolean = false
    override fun getPermissions(): List<String> = listOf("чтение")
}

class UserName(name: String) : AccessLevel(name) {
    override fun canRead(): Boolean = true
    override fun canWrite(): Boolean = true
    override fun canDelete(): Boolean = false
    override fun getPermissions(): List<String> = listOf("чтение", "запись")
}

class Admin(name: String) : AccessLevel(name) {
    override fun canRead(): Boolean = true
    override fun canWrite(): Boolean = true
    override fun canDelete(): Boolean = true
    override fun getPermissions(): List<String> = listOf("чтение", "запись", "удаление")
}

fun main() {
    val accessLevels: List<AccessLevel> = listOf(
        Guest("Антон"),
        UserName("Виктория"),
        Admin("Александра")
    )

    for (accessLevel in accessLevels) {
        println(accessLevel.info())
        println("Доступ чтение: ${accessLevel.canRead()}")
        println("Доступ запись: ${accessLevel.canWrite()}")
        println("Доступ удаление: ${accessLevel.canDelete()}")
        println()
    }
}