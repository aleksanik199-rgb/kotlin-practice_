package comboCode

class Task(val title: String) {
    var isCompleted = false

    fun completed() {
        isCompleted = true
    }

    fun info(): String {
        val checkbox = if (isCompleted) "[X]" else "[ ]"
        return "$checkbox $title"

    }
}

fun main() {
    val task = Task("Купить молоко")
    println(task.info())

    task.completed()
    println(task.info())
}