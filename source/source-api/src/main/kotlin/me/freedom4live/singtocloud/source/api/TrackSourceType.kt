package me.freedom4live.singtocloud.source.api

import me.freedom4live.singtocloud.translation.TitlePlaceHolder
import me.freedom4live.singtocloud.translation.TitlePlaceHolders

enum class TrackSourceType(val titlePlaceHolder: TitlePlaceHolder) {
    FILESYSTEM(TitlePlaceHolders.Source.FILE_SYSTEM)
}
