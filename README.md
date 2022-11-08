# 2way SSL demo 에 client role gateway
본 프로그램은 2way SSL 인증 방식에서 client 역할을 수행한다. 

## 준비 작업
1. keystore 생성
2. export 인증서 from keystore

> script.sh 파일에 생성 command 있음. 

### keystore 확인
keytool -list -v -keystore {PROJECT-HOME}/resources/keystore.jks


### gateway 동작 확인
GET https://gw.com/users/1   
위 요청을 하면 응답이 나온다.

>[주] 위 요청을 수행하면 default cacerts 즉 ${JAVA_HOME}/jre/cacerts 에 등록되어 있는 인증서에서 verify 를 수행한다.  
그런데, 데모 MS(micro service) 를 호출하게 했을 때, 해당 MS 서비스가 openSSL 기능으로 동작한다면, 추가로 trust-store 를 제공해야 한다. 


## 2way 인증 테스트 오류
```
io.netty.handler.codec.DecoderException: javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
```
이런 오류가 발생한다면, 요청하는 측에서 client 인증서를 서버에 제공하지 않았을 때이다. 이를 해결하려면, 요청하는 툴에서 인증서 포함한 요청이 이루어 져야 한다. 

### curl 테스트

## run
```
 mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djavax.net.debug=all"
```