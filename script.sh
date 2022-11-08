# keystore 생성
keytool -genkey -alias gateway -keyalg RSA -keystore keystore.jks -storetype pkcs12

# export 인증서
keytool -export -alias gateway -keystore keystore.jks -file gw.crt

# curl 툴을 이용하여 client 용 인증서 호출을 테스트 활 수 있다.
# private key 추출
openssl pkcs12 -info -nodes -nocerts -out gw.key -in /Users/donheekang/workspace/tmp/1103/demo-2way-ssl/demo-gw/src/main/resources/keystore.jks

# PEM 양식 인증서 추출
keytool -export -alias gateway -rfc -file gw.pem -keystore /Users/donheekang/workspace/tmp/1103/demo-2way-ssl/demo-gw/src/main/resources/keystore.jks


# trust-store 생성
keytool -importcert -keystore cacerts.jks -trustcacerts -alias gateway -file /Users/donheekang/workspace/tmp/1103/demo-2way-ssl/demo-ms/ms.crt

# import the reqres certification
keytool -importcert -keystore cacerts.jks -trustcacerts -alias reqres -file /Users/donheekang/Downloads/reqres.cer

# trust store 내용 보기
keytool -list -v -keystore cacerts.jks