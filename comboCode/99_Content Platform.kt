package comboCode

abstract class Content(val title: String, val author: String, val durationSec: Int) {

    init {
        require(durationSec > 0) {"Продолжительность должна быть больше 0"}
    }

    fun formattedDuration(): String {
        val minutes = durationSec / 60
        val seconds = durationSec % 60
        return "%02d:%02d".format(minutes, seconds)
    }

    abstract fun play(): String

    fun info(): String {
        return "[${this::class.simpleName}] '$title' by $author (${formattedDuration()})"
    }
}

class Podcast(title: String, author: String, durationSec: Int, val episodeNumber: Int): Content(title, author, durationSec) {
    override fun play(): String {
        return "Подкаст $title автор $author продолжительность ${formattedDuration()} номер эпизода $episodeNumber"
    }
}

class MusicTrack(title: String, author: String, durationSec: Int, val genre: String): Content(title, author, durationSec) {
    override fun play(): String {
        return "Трек $title автор $author продолжительность ${formattedDuration()} жанр $genre"
    }
}

fun main() {
    val contents: List<Content> = listOf(
        Podcast("Закат империи", "Андрей Аксёнов", 2400, 1),
        Podcast("Почему мы ещё живы", "Фёдор Катасонов", 2100, 3),
        MusicTrack("Body to body", "BTS", 190, "Alternative Hip-Hop"),
        MusicTrack("Like Animals", "BTS", 190, "Indie Rock")
    )

    for (content in contents) {
        println(content.play())
        println(content.info())
        println()
    }
}