rootProject.name = "sing-to-cloud"

include(
        ":application:application-javafx",

        ":frontend:javafx:javafx-api",
        ":frontend:javafx:javafx-impl",

        ":cloud-integration:spotify:spotify-api",
        ":cloud-integration:spotify:spotify-impl",

        ":source:local-source",
        ":source:source-api"
)
