package com.github.DevSanso.payment.toss.data

import kotlinx.serialization.Serializable

@Serializable
data class PaymentRequestResponse(
    val code : Int, //응답코드
    val checkoutPage : String, //결제를 진행할 수 있는 토스페이 웹페이지 URL 토스가 전달한 값 그대로를 구매자에게 띄워주세요.
    val payToken : String, //토스페이 토큰 가맹점에서는 이 값을 반드시 저장하고 관리하셔야 합니다.
    val msg : String, //응답이 성공이 아닌 경우 설명 메세지
    val errorCode : String //에러 코드
)
