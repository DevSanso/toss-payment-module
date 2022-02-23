/*
toss payment service code

toss pay rest api docs => https://tossdev.github.io/api.html#payments
 */

package com.github.DevSanso.payment.toss

import kotlinx.serialization.*
import kotlinx.serialization.json.*


import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody

import com.github.DevSanso.payment.toss.data.*

class TossPaymentSystem(val resultReciverUrl : String)  {
    private val payRequestUrl = "https://pay.toss.im/api/v2/payments"

    private inline fun makeRequestHeader() = Headers.Builder()
        .add("Content-Type","application/json")
        .build()

    private inline fun makeRequestBody(data : PaymentRequest) : String = Json.encodeToString(data)
    private fun makeRequest(data : PaymentRequest) = Request.Builder()
        .url(payRequestUrl)
        .headers(makeRequestHeader())
        .post(makeRequestBody(data).toRequestBody())
        .build()




}