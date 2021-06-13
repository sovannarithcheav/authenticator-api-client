package kh.org.sora.authentication_api.service

import kh.org.sora.authentication_api.request.PairingReq
import kh.org.sora.authentication_api.request.ValidatePinReq
import kh.org.sora.authentication_api.response.PairingRes

interface IAuthenticatorService {
    fun pairing(request: PairingReq): PairingRes
    fun validatePin(request: ValidatePinReq): Boolean
}