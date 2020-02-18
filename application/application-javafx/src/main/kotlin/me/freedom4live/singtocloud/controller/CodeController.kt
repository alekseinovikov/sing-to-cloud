package me.freedom4live.singtocloud.controller

import me.freedom4live.singtocloud.runner.SpotifyRunner
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import kotlin.concurrent.thread

class CodeController(private val spotifyRunner: SpotifyRunner) {

    @GetMapping("spotify-redirect")
    fun authCodeRedirect(@RequestParam(name = "code") code: String): String {
        thread { spotifyRunner.codeUpdated(code) }

        return "OK"
    }

}
