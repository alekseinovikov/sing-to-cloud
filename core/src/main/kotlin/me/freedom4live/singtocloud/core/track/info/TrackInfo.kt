package me.freedom4live.singtocloud.core.track.info

open class TrackInfo(val title: String?,
                     val artist: String?,
                     val album: String?,
                     val genre: String?,
                     val creator: String?) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TrackInfo) return false

        if (title != other.title) return false
        if (artist != other.artist) return false
        if (album != other.album) return false
        if (genre != other.genre) return false
        if (creator != other.creator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (artist?.hashCode() ?: 0)
        result = 31 * result + (album?.hashCode() ?: 0)
        result = 31 * result + (genre?.hashCode() ?: 0)
        result = 31 * result + (creator?.hashCode() ?: 0)
        return result
    }

}
