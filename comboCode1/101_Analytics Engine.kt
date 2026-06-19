package comboCode1

import comboCode1.DataSource

abstract class DataSource(val name: String, val refreshIntervalMin: Int) {
    init {
        require(name.isNotEmpty()) {"Значение не может быть пустым"}
        require(refreshIntervalMin in 1..1440) {"Значение должно быть в диапазоне от 1 до 1440"}
    }

    private var _recordsProcessed: Int = 0
    val recordsProcessed: Int
    get() = _recordsProcessed

    abstract fun fetchData(): List<String>

    fun process(): String {
        val data = fetchData()
        _recordsProcessed += data.size
        return "[$name] processed ${data.size} records. Total: $_recordsProcessed"
    }
}

class DatabaseSource(name: String, refreshIntervalMin: Int, val tableNames: List<String>): DataSource(name, refreshIntervalMin) {
    override fun fetchData(): List<String> {
        return tableNames.map { "row from $it"  }
    }
}

class ApiSource(name: String, refreshIntervalMin: Int, val endpoint: String, val batchSize: Int): DataSource(name, refreshIntervalMin) {
    override fun fetchData(): List<String> {
        return (1..batchSize).map { "record_$it from $endpoint" }
    }
}

fun main() {
    val db = DatabaseSource("PostgreSQL", 350, listOf("users", "orders", "products"))
    val api = ApiSource("UserAPI", 120, "https://api.example.com/users", 5)

    println(db.process())
    println(db.process())
    println("Total: ${db.recordsProcessed}")
    println()

    println(api.process())
    println(api.process())
    println("Total: ${api.recordsProcessed}")

    val sources = listOf(db, api)
    runPipeline(sources)
}

fun runPipeline(sources: List<DataSource>) {
    for (source in sources) {
        println(source.process())
        println()
    }
}
