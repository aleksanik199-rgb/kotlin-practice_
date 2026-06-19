package comboCode

abstract class ReportGenerator(val data: List<String>) {
    abstract fun generate(): String
    abstract fun getExtension(): String

    fun saveToFile(): String {
        return "Отчёт сохранён как report${getExtension()}"
    }
}

class TxtReport(data: List<String>): ReportGenerator(data) {
    override fun generate(): String = data.joinToString("\n")
    override fun getExtension(): String = ".txt"
}

class CsvReport(data: List<String>): ReportGenerator(data) {
    override fun generate(): String = data.joinToString(";")
    override fun getExtension(): String = ".csv"
}

class HtmlReport(data: List<String>): ReportGenerator(data) {
    override fun generate(): String {
        val items = data.map { "<li>$it</li>" }.joinToString("\n")
        return "<ul>\n$items\n</ul>"
    }
    override fun getExtension(): String = ".html"
}

fun main() {
    val generators: List<ReportGenerator> = listOf(
        TxtReport(listOf("Работа")),
        CsvReport(listOf("Данные")),
        HtmlReport(listOf("Код"))
    )

    for (generator in generators) {
        println(generator.saveToFile())
        println(generator.generate())
        println(generator.getExtension())
        println()
    }
}