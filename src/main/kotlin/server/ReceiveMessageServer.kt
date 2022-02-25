package com.github.DevSanso.payment.toss.server
import java.util.concurrent.ConcurrentHashMap

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.call
import io.ktor.server.routing.*
import io.ktor.server.request.*
import kotlinx.serialization.json.*

import com.github.DevSanso.payment.toss.data.PaymentResult
import kotlinx.serialization.decodeFromString


interface ServerMediation {
    suspend fun waitPaymentResult(payToken : String) : PaymentResult
}


class ReceiveMessageServer(host : String, port : Int, path : String) : ServerMediation {
    private val httpEngine : ApplicationEngine
    private val map : ConcurrentHashMap<String,PaymentResult> = ConcurrentHashMap()

    init {
        httpEngine = embeddedServer(Netty, port = port, host = host) {
            routing {
                post(path) { entryPoint(call.receiveText()) }
            }
        }
    }

    private fun entryPoint(requestBody : String) {
        val body = Json.decodeFromString<PaymentResult>(requestBody)
        map[body.payToken] = body
    }

    override suspend fun waitPaymentResult(payToken: String): PaymentResult {
        while(map.keys.any{it == payToken}){}
        return map[payToken]!!
    }


    fun start() = httpEngine.start(wait = true)
    fun stop() = httpEngine.stop(10L,10L)
}