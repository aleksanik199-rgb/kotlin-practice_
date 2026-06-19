package comboCode

fun main() {
    print("Введите сумму в $: ")
    val usd = readln().toDouble()
    print("Введите курс рубля: ")
    val rate = readln().toDouble()

    val converter = usdToRub(usd, rate)

    println("Сумма в рублях: $converter руб.")
}

fun usdToRub(usd: Double, rate: Double): Double {
    return rate * usd
}