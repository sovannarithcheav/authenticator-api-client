package kh.org.soramitsu.authentication_api.service

import com.fasterxml.jackson.databind.ObjectMapper
import kh.org.soramitsu.authentication_api.client.AuthenticationClient
import kh.org.soramitsu.authentication_api.request.PairingReq
import kh.org.soramitsu.authentication_api.request.ValidatePinReq
import kh.org.soramitsu.authentication_api.response.PairingRes
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AuthenticatorService(
    private val authenticationClient: AuthenticationClient
): IAuthenticatorService {
    private val log = LoggerFactory.getLogger(AuthenticatorService::class.java)

    override fun pairing(request: PairingReq): PairingRes {
        log.info("Pairing Request: {}", request)
        val pairing = authenticationClient.pairing(request).getData() as JSONObject
        val manualSetupCode = pairing.getString("ManualSetupCode")
        val html = pairing.getString("Html")
        val pairingRes = PairingRes(manualSetupCode, html)
        log.info("Pairing Response: {}", pairingRes)
        return pairingRes
    }

    override fun validatePin(request: ValidatePinReq): Boolean {
        log.info("Validate Pin Request: {}", request)
        val bool = authenticationClient.validatePin(request).getData() as Boolean
        log.info("Validate Pin Response: {}", bool)
        return bool
    }

    private fun String.getData(): Any {
        return ObjectMapper().convertValue(this, JSONObject::class.java).get("d")
    }
}