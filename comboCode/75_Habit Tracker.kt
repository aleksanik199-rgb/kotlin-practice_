package comboCode

class Habit(val name: String, val timesPerWeek: Int, var currentStreak: Int) {

    fun log() {
        currentStreak++
    }

    fun info(): String {
        return "Привычка: $name, цель: $timesPerWeek раз в неделю, текущая серия: $currentStreak дня"
    }
}

class HabitTracker {
    val habits =  mutableListOf<Habit>()

    fun addHabit(habit: Habit) {
        if (habit.timesPerWeek > 0) {
            habits.add(habit)
        }
    }

    fun showAllHabits() {
        for (habit in habits) {
            println(habit.info())
        }
    }
}

fun main() {
    val habit1 = Habit("Делать заряку", 5, 2)
    val habit2 = Habit("Гулять по вечерам", 4, 1)

    val habitTracker = HabitTracker()

    habitTracker.addHabit(habit1)
    habitTracker.addHabit(habit2)

    habit1.log()
    habit2.log()

    habitTracker.showAllHabits()
}