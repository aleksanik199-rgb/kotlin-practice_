package comboCode

open class Animal(val name: String, protected val animalType: String = "Животное") {
    open fun makeSound() {
        println("Животное издаёт звук")
    }
}

class Dog : Animal("Бобик") {
    override fun makeSound() {
        super.makeSound()
        println("$name ($animalType): Гав!")
    }
}

class Cat: Animal("Мурка") {
    override fun makeSound() {
        println("$name: Мяу!")
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat()

    dog.makeSound()
    cat.makeSound()
}