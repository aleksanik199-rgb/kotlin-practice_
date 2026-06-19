package comboCode

fun main() {
    val sum = 1000
    val friends = 16

    val splittingAccount = sum / friends
    val discountPercent = discountFriends(friends)
    val discount = splittingAccount * discountPercent / 100
    val sumdiscount = splittingAccount - discount

    println("Счёт: $sum")
    println("Друзей: $friends")
    if (discountPercent > 0){
        println("Скидка: $discountPercent")
        println("Каждый платит со скидкой: $sumdiscount")
    } else {
        println("Каждый платит: $splittingAccount")
    }
}

fun discountFriends(friends: Int): Int{
    return if(friends > 10) 5 else 0
}