# back_springboot_mybatis

1. 로그인/회원가입 보안
   < Basic Authentication >
   1-1. 사용자 이름/비밀번호를 Base64로 인코딩하여 Authorization 헤더에 포함하여 전송
   1-2. 매우 안전하지 않음. SSL/TLS와 함께 사용됨

   Authorization: Basic ~~~

   < Bearer Token Authentication >
   2-1. 헤더에 토큰을 포함하여 전송. Authorization 헤더에 포함하여 전송
   2-2. JWT 을 사용하여 인증
   2-3. 간단한 방식, 상태를 유지하지 않음, 확장성이 높음
   2-4. 토큰 노출 위험, 토큰 관리 필요

   Authorization: Bearer ~~~

   < OAuth >
   3-1. 토큰 기반 인증 방식, 사용자가 직접 자격을 증명하지 않음. 미리 인증 받아서 토큰을 발급받음
   3-2. 해당 토큰을 이용하여 API를 요청하는 방식 OAuth 2.0

   Kakao / Naver / Git / Facebook

   API Key / Session based Authentication

   JWT(Json Web Token) : 클레임이라고 불리는 정보를 Json의 형태로 안전하게 전송하기 위한 토큰 기반의 표준 보안
   - 인증과 정보 교환에 사용, 서명이 되어 있어서 신뢰성 확보가 가능
   1) Header : 토큰의 타입과 사용된 알고리즘 정보를 담고 있음. Base64Url로 인코딩
   2) Payload : 클레임 정보, 대상, 발행자, 만료 시간 등 다양한 정보가 포함됨. Base64Url로 인코딩
   3) Signature: Header와 Payload, Scret key를 사용하여 생성된 서명

   인증, 정보교환

   장점
   - 상태유지 X
   - 간단하고 자기 포함적
   - 확장성

   단점
   - 크기 : 클레임이 많을 수록 토큰의 크기가 커짐
   - 보안 : 서명은 되어있지만 암호화는 되어있지 않음. 중요한 정보를 JWT에 포함하면 안됨.
   - 토큰 관리 : 만료 시간, 갱신 



// HS512 알고리즘 시크릿키
// 사이트에서 길이 64로 생성
https://passwords-generator.org/kr/#google_vignette
