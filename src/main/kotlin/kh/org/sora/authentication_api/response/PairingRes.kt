package kh.org.sora.authentication_api.response

data class PairingRes(
    val manualSetupCode: String,
    val html: String,
)