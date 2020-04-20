package me.freedom4live.singtocloud.core.track

import me.freedom4live.singtocloud.core.source.TrackSource

abstract class TrackSourceInfo {
    abstract fun getSource(): TrackSource
}
