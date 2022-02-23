package com.github.DevSanso.payment.toss.data

import kotlinx.serialization.Serializable

@Serializable
data class PaymentResult(
    val status : String, //결제 완료
    val payToken : String, //승인된 결제 토큰
    val orderNo : String, //결제생성 구간에서 전달된 가맹점 주문번호
    val payMethod : String, //승인된 결제수단
    val amount : Int, //결제요청된 금액
    val discountedAmount : Int, //할인된 금액
    val paidAmount : Int, //지불수단 승인금액
    val paidTs : String, //결제 완료 처리 시간
    val transactionId : String, //거래 트랜잭션 아이디
    val cardCompanyCode : String, //승인된 카드사 코드
    val cardAuthorizationNo : String, //카드 승인번호
    val spreadOut : String, //사용자가 선택한 카드 할부개월
    val noInterest: Boolean, //카드 무이자 적용 여부
    val cardMethodType : String, //카드 타입
    val cardNumber : String, //마스킹된 카드번호
    val salesCheckLinkUrl : String //신용카드 매출전표 호출URL
)