package com.github.DevSanso.payment.toss
/*
toss payment service code

toss pay rest api docs => https://tossdev.github.io/api.html#payments
 */

import kotlinx.serialization.*
import kotlinx.serialization.json.*

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody


import com.github.DevSanso.payment.toss.data.*
import com.github.DevSanso.payment.toss.server.ReceiveMessageServer

class TossPaymentSystem(val host : String,val port : Int,callbackPath : String)  {
    private val payRequestUrl = "https://pay.toss.im/api/v2/payments"
    private val paymentReceive : ReceiveMessageServer
    init {
        paymentReceive = ReceiveMessageServer(host,port,callbackPath)
        paymentReceive.start()
    }
    private inline fun makeRequestHeader() = Headers.Builder()
        .add("Content-Type","application/json")
        .build()

    private inline fun makeRequestBody(data : PaymentRequest) : String = Json.encodeToString(data)
    private inline fun makeRequest(data : PaymentRequest) = Request.Builder()
        .url(payRequestUrl)
        .headers(makeRequestHeader())
        .post(makeRequestBody(data).toRequestBody())
        .build()

    fun createRequest(data : PaymentRequest) : RequestPresenter{
        val client = OkHttpClient()
        val res = client.newCall(makeRequest(data)).execute()

        return RequestPresenter(
            Json.decodeFromString<PaymentRequestResponse>(res.body.toString())
        )
    }

    fun close() {paymentReceive.stop()}
}