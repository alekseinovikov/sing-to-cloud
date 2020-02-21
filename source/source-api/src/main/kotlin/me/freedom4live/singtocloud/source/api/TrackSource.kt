package me.freedom4live.singtocloud.source.api

import me.freedom4live.singtocloud.source.api.model.TrackMetaData
import me.freedom4live.singtocloud.source.api.model.TrackRequest

interface TrackSource {
    fun findTracks(trackRequest: TrackRequest): List<TrackMetaData>
    fun supports(): TrackSourceType
}
