package org.example.com.factorypattern

interface Video {
    val title: String
    fun play()
}

object VideoFactory {
    fun create(type: String, title: String): Video {
        return when(type.lowercase()) {
            "speedrun" -> SpeedrunVideo(title)
            "review" -> ReviewVideo(title)
            "tutorial" -> TutorialVideo(title)
            else -> throw IllegalArgumentException("Unknown video type: $type")
        }
    }
}

class SpeedrunVideo(override val title: String) : Video {
    override fun play() {
        println("Playing speedrun: ${this.title}")
    }
}

class ReviewVideo(override val title: String) : Video {
    override fun play() {
        println("Reviewing speedrun: ${this.title}")
    }
}

class TutorialVideo(override val title: String) : Video {
    override fun play() {
        println("Tutorialing speedrun: ${this.title}")
    }
}
