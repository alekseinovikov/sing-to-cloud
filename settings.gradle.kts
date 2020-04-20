rootProject.name = "sing-to-cloud"

include(
        "core",
        ":cloud-integration:spotify:spotify-api",
        ":cloud-integration:spotify:spotify-impl"
)
