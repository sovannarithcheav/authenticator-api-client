package kh.org.sora.authentication_api.service

import com.fasterxml.jackson.databind.ObjectMapper
import kh.org.sora.authentication_api.client.AuthenticationClient
import kh.org.sora.authentication_api.request.PairingReq
import kh.org.sora.authentication_api.request.ValidatePinReq
import kh.org.sora.authentication_api.response.PairingRes
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class AuthenticatorService(
    private val authenticationClient: AuthenticationClient
): IAuthenticatorService {
    override fun pairing(request: PairingReq): PairingRes {
        val pairing = authenticationClient.pairing(request).getData() as JSONObject
        val manualSetupCode = pairing.getString("ManualSetupCode")
        val html = pairing.getString("Html")
        return PairingRes(manualSetupCode, html)
    }

    override fun validatePin(request: ValidatePinReq): Boolean {
        return authenticationClient.validatePin(request).getData() as Boolean
    }

    private fun String.getData(): Any {
        return ObjectMapper().convertValue(this, JSONObject::class.java).get("d")
    }
}