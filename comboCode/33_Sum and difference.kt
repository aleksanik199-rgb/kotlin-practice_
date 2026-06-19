package comboCode

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val operation = readln()

    val result = calculate(a, b, operation)
    println("Итог $result")
}

fun calculate(a: Int, b: Int, operation: String): Int{
    return if(operation == "+"){
        a + b
    }else if(operation == "-"){
        a - b
    }else{
    println("Ошибка: неизвестная операция")
    0
    }
}