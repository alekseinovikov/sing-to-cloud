package me.freedom4live.singtocloud.source.api

import me.freedom4live.singtocloud.source.api.model.TrackRequest
import me.freedom4live.singtocloud.source.api.model.TrackResponse

interface TrackSource {
    fun findTracks(trackRequest: TrackRequest): List<TrackResponse>
    fun supports(): TrackSourceType
}
