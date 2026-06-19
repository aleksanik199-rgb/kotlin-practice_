package comboCode

class EmployeeProfile(_fullName: String, _salary: Double, _level: String) {
    var fullName: String = _fullName
        set(value) {
            require(value.isNotEmpty()) { "ФИО не может быть пустым"}
            field = value.trim().split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { c -> c.uppercase() }}
        }

    var salary: Double = _salary
    private set
    init {
        fullName = _fullName
        require(_salary >= 30000.0) { "Зарплата не может быть меньше 30000р" }
    }

    var level: String = _level
    private set

    private val levels = listOf("JUNIOR", "MIDDLE", "SENIOR")

    val annualIncome: Double
        get() = (salary * 12)

    lateinit var department: String

    fun promote(newSalary: Double, newLevel: String) {
        require(newLevel in listOf("JUNIOR", "MIDDLE", "SENIOR")) { "Недопустимый уровень" }
        require(newSalary > salary) {"Новая зарплата должна быть выше текущей"}
        require(levels.indexOf(newLevel)> levels.indexOf(level)) {"Новый уровень должен быть выше текущего"}
        salary = newSalary
        level = newLevel
    }

    fun assignDepartment(dept: String) {
        department = dept
    }

    fun getSummary(): String {
        val dept = if (::department.isInitialized) department else "Не назначен"
        return "ФИО сотрудника: $fullName, зарплата: $salary руб., уровень: $level, отдел: $dept"
    }
}

fun main() {
    val emp1 = EmployeeProfile("занозин виктор викторович", 50000.0, "JUNIOR")
    val emp2 = EmployeeProfile("степанова маргарита павловна", 150000.0, "MIDDLE")
    val emp3 = EmployeeProfile("петрова арина евгеньевна", 30000.0, "SENIOR")


    emp1.promote(100000.0, "MIDDLE")
    emp2.promote(300000.0, "SENIOR")

    emp1.assignDepartment("Разработка")
    emp2.assignDepartment("Дизайн")
    emp3.assignDepartment("Защита данных")

    println(emp1.getSummary())
    println(emp2.getSummary())
    println(emp3.getSummary())
}