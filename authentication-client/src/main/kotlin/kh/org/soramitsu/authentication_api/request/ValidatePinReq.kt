package kh.org.soramitsu.authentication_api.request

data class ValidatePinReq(
    val pin: String,
    val secretCode: String
)