package me.freedom4live.singtocloud.runner

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.SpotifyHttpManager
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SpotifyRunner : CommandLineRunner {

    private val CLINET_ID = "7773d63802354756b6abf06f5872fc55"
    private val CLINET_SECRET = "e7ff11e152524e66b221fcddddc298d2"
    private val SCOPES = "user-library-read user-library-modify playlist-modify-private playlist-read-private playlist-modify-public playlist-read-collaborative user-read-private user-read-email"
    private val CLIENT_REDIRECT_URL = SpotifyHttpManager.makeUri("http://localhost:8080/spotify-redirect")

    val api = SpotifyApi.Builder()
            .setClientId(CLINET_ID)
            .setClientSecret(CLINET_SECRET)
            .setRedirectUri(CLIENT_REDIRECT_URL)
            .build()

    override fun run(vararg args: String?)  {
        val execute = api.authorizationCodeUri()
                .scope(SCOPES)
                .build()

        println(execute.execute())
    }

    fun codeUpdated(code: String) {
        val codeRequest = api.authorizationCode(code).build()

        val authCode = codeRequest.execute()

        api.accessToken = authCode.accessToken
        api.refreshToken = authCode.refreshToken

        val refreshRequest = api.authorizationCodeRefresh().build()
        val creds = refreshRequest.execute()

        api.accessToken = creds.accessToken
        api.refreshToken = creds.refreshToken

        val executer = api.currentUsersProfile.build()
        val user = executer.execute()


        println(user.id)

        val build = api.createPlaylist(user.id, "TEST_PLAYLIST").build()
        val newPlaylist = build.execute()

        println(newPlaylist)
    }

}
