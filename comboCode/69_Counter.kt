package comboCode

class Counter {
    var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        if (count > 0) {
            count--
        }
    }

    fun current(): Int{
        return count
    }
}

fun main() {
    val counter = Counter()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.decrement()
    println(counter.current())
}