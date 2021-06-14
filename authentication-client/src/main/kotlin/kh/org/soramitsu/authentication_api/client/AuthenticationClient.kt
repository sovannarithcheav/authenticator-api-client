package kh.org.soramitsu.authentication_api.client

import kh.org.soramitsu.authentication_api.request.PairingReq
import kh.org.soramitsu.authentication_api.request.ValidatePinReq
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping

/**
 * Same secretCode will generate the same pin code. AppName & appInfo not count.
 */
@FeignClient("authentication-api", url = "https://authenticatorapi.com/api.asmx")
interface AuthenticationClient {
    @GetMapping("/ValidatePin", produces = [MediaType.TEXT_XML_VALUE])
    fun validatePin(req: ValidatePinReq): String

    @GetMapping("/Pair", produces = [MediaType.TEXT_XML_VALUE])
    fun pairing(req: PairingReq): String
}