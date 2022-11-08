package com.example.demogw.config;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.ResourceUtils;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.SslContextBuilder;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Configuration
public class WebClientConfig {

    @Value("${server.ssl.key-store:''}")
    private String keyStore;

    @Value("${server.ssl.key-store-password:''}")
    private String keyStorePassword;

    // @Value("${server.ssl.trust-store:''}")
    private String trustStore;

    // @Value("${server.ssl.trust-store-password:''}")
    private String trustStorePassword;
    
    // @Bean
    // public WebClient webClient() {

    //     return WebClient.builder()
    //     .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
    //     .build();  
    // } 

    // private HttpClient getHttpClient() {
    //     return HttpClient.create().secure(spec ->
    //     {
    //       try {
    //         KeyStore keyStore1 = KeyStore.getInstance("PKCS12");
    //         keyStore1.load(new FileInputStream(ResourceUtils.getFile(keyStore)), keyStorePassword.toCharArray());
       
    //         KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    //         keyManagerFactory.init(keyStore1, keyStorePassword.toCharArray());
       
    //         KeyStore trustStore1 = KeyStore.getInstance("JKS");
    //         trustStore1.load(new FileInputStream((ResourceUtils.getFile(trustStore))), trustStorePassword.toCharArray());
       
    //         TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    //         trustManagerFactory.init(trustStore1);
       
    //         spec.sslContext(SslContextBuilder
    //                           .forClient()
    //                           .keyManager(keyManagerFactory)
    //                           .trustManager(trustManagerFactory)
    //                           .build());
    //       } catch (Exception e) {
    //         log.error("Unable to set SSL Context", e);
    //       }
    //     });
       
    // }
 


}
