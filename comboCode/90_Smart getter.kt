package comboCode

class Wallets {
    var amountInCents: Int = 0

    val amountInDollars: String
    get() = "%.2f".format(amountInCents / 100.0)
}
fun main() {
    val wallets = Wallets()
    wallets.amountInCents = 500
    println(wallets.amountInDollars)
}