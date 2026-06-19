package comboCode

fun main() {
    val movies = mutableMapOf<String, Int>()

    while (addMovie(movies)){
    }

    println("Количество фильмов: ${movies.size}")

    if (movies.isNotEmpty()){
        val longMovies = findLongestMovie(movies)
        println("Самый длинный фильм: ${longMovies.first} (${longMovies.second} мин)")
    }else{
        println("Нет фильмов")
    }

    val avg = averageDuration(movies)
    println("Средняя продолжительность: $avg")

    shortMovies(movies)
}

fun addMovie(movies: MutableMap<String, Int>): Boolean{
    print("Добавлен: ")
    val name = readln()
    if (name == "стоп"){
        return false
    }

    print("Введите время: ")
    val time = readln().toInt()
    movies[name] = time
    return true
}

fun findLongestMovie(movies: MutableMap<String, Int>): Pair<String, Int> {
    var nameMax = ""
    var timeMax = 0
    for ((name, time) in movies) {
        if (time > timeMax) {
            nameMax = name
            timeMax = time
        }
    }
    return Pair(nameMax, timeMax)
}

fun averageDuration(movies: MutableMap<String, Int>): Int{
    return movies.values.average().toInt()
}

fun shortMovies(movies: MutableMap<String, Int>){
    val shorter = movies.filter { it.value < 120 }
    for ((name, time) in shorter){
        println("Фильмы короче 120 минут: $name ($time) мин")
    }
}