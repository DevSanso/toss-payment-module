package com.github.DevSanso.payment.toss.data

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class PaymentRequest(
    @Required val apiKey : String, //가맹점 key
    @Required val orderNo : Int, //가맹점의 상품 주문번호
    @Required val productDesc : String, //상품 설명
    @Required val retUrl : String, //구매자 인증완료 후 연결할 가맹점 웹페이지 URL
    @Required val retCancelUrl : String, //토스페이창에 진입한 사용자가 결제를 중단할때 사용자를 이동시킬 가맹점 취소 페이지
    @Required val amount : Int, //총 결제 금액
    @Required val amountTaxFree : Int, //결제 금액 중 비과세금액
    val amountTaxable : Int?, //결제 금액 중 과세금액
    val amountVat : Int?, //결제 금액 중 부가세
    val retAppScheme : String?, //결제 완료 후 연결할 가맹점 측 앱 스킴 값
    val resultCallback : String, //결제 결과 callback URL (필수)
    val autoExecute : String = "true", //자동 승인 여부 설정 ("false","true")
    val callbackVersion : String = "v2" //결제 결과 callback 버전 ("v1","v2")
)