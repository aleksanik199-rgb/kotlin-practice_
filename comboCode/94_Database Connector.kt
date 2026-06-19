package comboCode

class DatabaseConnector {
    val connector: String by lazy{
        println("Тяжелая инициализация...")
        "Подключение БД установлено"
    }

    lateinit var apiKey: String

    fun isApiKeyReady(): Boolean = ::apiKey.isInitialized
}

fun main() {
    val db = DatabaseConnector()
    println("Ключ задан? ${db.isApiKeyReady()}")
    db.apiKey = "SECRET_123"
    println("Статус: ${db.isApiKeyReady()}")
    println(db.connector)
}