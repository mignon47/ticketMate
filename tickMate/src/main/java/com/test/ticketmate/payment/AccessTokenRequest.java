package com.test.ticketmate.payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class AccessTokenRequest { // 인증 토큰 발급 받기

    public static void main(String[] args) throws IOException {
    	 // RestTemplate 객체 생성
        RestTemplate restTemplate = new RestTemplate();

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 본문 데이터
        String requestBody = "{ \"imp_key\": \"imp_apikey\", \"imp_secret\": \"ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f\" }";
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // API URL 설정
        String url = "https://api.iamport.kr/users/getToken";

        // POST 요청 수행
        String response = restTemplate.postForObject(url, request, String.class);

        // 응답 출력
        System.out.println(response);
    }
}