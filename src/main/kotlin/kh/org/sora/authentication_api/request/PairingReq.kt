package kh.org.sora.authentication_api.request

data class PairingReq(
    val appName: String,
    val appInfo: String,
    val secretCode: String
)