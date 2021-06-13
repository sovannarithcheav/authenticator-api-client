package kh.org.sora.authentication_api.request

data class ValidatePinReq(
    val pin: String,
    val secretCode: String
)