package algorithmic_logic

fun main() {
    val t = readln().toInt()
    val nextIndex = mutableMapOf<String, Int>()
    val used = mutableSetOf<String>()

    repeat(t) {
        val name = readln()

        val verifying = verifyingUserName(name, used, nextIndex)

        println(verifying)
    }
}

fun verifyingUserName(name: String, used: MutableSet<String>, nextIndex: MutableMap<String, Int> ): String {
    var i = nextIndex.getOrDefault(name, 1)

    if (used.add(name)) {
        return "OK"
    }
    while ("$name$i" in used) {
        i++
    }
    used.add("$name$i")
    nextIndex[name] = i + 1
    return "$name$i"
}