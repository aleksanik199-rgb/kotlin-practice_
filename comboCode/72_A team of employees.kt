package comboCode

class Employee(val name: String, val age: Int, val salary: Double, val yearsOfExperience: Int) {
    fun info(): String {
        return "Сотрудник: $name, возраст: $age, зарплата: $salary"
    }
    fun bonus(): Double {
        return when {
            yearsOfExperience < 2 -> 0.0
            yearsOfExperience <= 5 -> salary * 0.1
            else -> salary * 0.2
        }
    }
}

class Teams {
    val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    fun totalSalary(): Double {
        return employees.sumOf { it.salary }
    }

    fun averageAge(): Double {
        return employees.map { it.age }.average()
    }

    fun totalWithBonus(): Double {
        return employees.sumOf { it.salary + it.bonus() }
    }

    fun averageSalaryWithBonus(): Double {
        return employees.map { it.salary + it.bonus() }.average()
    }

    fun findByName(name: String): Employee? {
       if (name.isEmpty()) return null

       return employees.find { it.name == name }
    }

    fun filterByMinSalary(minSalary: Double): List<Employee> {
        return employees.filter { it.salary > minSalary }
    }

    fun sortedBySalary(): List<Employee> {
        return employees.sortedBy { it.salary }
    }
}

fun main() {
    val employee1 = Employee("Александра", 26, 500000.0, 4)
    val employee2 = Employee("Мария", 30, 350000.0, 3)
    val employee3 = Employee("Василиса", 28, 450000.0, 1)
    val employee4 = Employee("Арина", 25, 300000.0, 2)

    val team = Teams()

    team.addEmployee(employee1)
    team.addEmployee(employee2)
    team.addEmployee(employee3)
    team.addEmployee(employee4)

    println("Сотрудники с зарплатой больше 400000 руб: ")
    for (employee in team.filterByMinSalary(400000.0)) {
        println(employee.info())
    }

    val found = team.findByName("Мария")
    if (found != null) {
        println("Найден сотрудник по запросу: ${found.info()}")
    } else {
        println("Сотрудник не найден")
    }

    println("Сотрудники по возрастанию зарплаты: ")
    for (employee in team.sortedBySalary()) {
        println(employee.info())
    }

    println(employee1.info())
    println("Общая зарплата без бонуса: ${team.totalSalary()}")
    println("Общая зарплата с бонусом: ${team.totalWithBonus()}")
    println("Средняя зарплата с бонусом: ${team.averageSalaryWithBonus()}")
    println("Средний возраст: ${team.averageAge()}")
}