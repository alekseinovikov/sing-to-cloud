rootProject.name = "sing-to-cloud"

include(
        ":core:media-type",
        ":core:song-metadata",

        ":application:application-javafx",

        ":frontend:javafx:javafx-api",
        ":frontend:javafx:javafx-impl",

        ":cloud-integration:spotify:spotify-api",
        ":cloud-integration:spotify:spotify-impl",

        ":source:local-source",
        ":source:source-api"
)
