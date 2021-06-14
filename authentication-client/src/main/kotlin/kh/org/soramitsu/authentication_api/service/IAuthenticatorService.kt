package kh.org.soramitsu.authentication_api.service

import kh.org.soramitsu.authentication_api.request.PairingReq
import kh.org.soramitsu.authentication_api.request.ValidatePinReq
import kh.org.soramitsu.authentication_api.response.PairingRes

interface IAuthenticatorService {
    fun pairing(request: PairingReq): PairingRes
    fun validatePin(request: ValidatePinReq): Boolean
}