package com.github.DevSanso.payment.toss

import com.github.DevSanso.payment.toss.data.*
import com.github.DevSanso.payment.toss.server.ServerMediation


class RequestPresenter(private val response: PaymentRequestResponse,val server : ServerMediation){
    val isError : Boolean get() = response.code == -1
    val payToken : String get() = response.payToken
    val checkoutPage : String get() = response.checkoutPage

    data class ErrorMessage(
        val msg : String,
        val errorCode : String
    )
    val errMessage : ErrorMessage? get() {
        return if (response.code != 0) {
            null
        } else ErrorMessage(response.msg,response.errorCode)
    }

}