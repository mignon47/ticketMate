package com.test.ticketmate.payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
	 // AccessToken 호출
		public String getAccessToken(TokenRequest tokenRequest) {
	        RestTemplate restTemplate = new RestTemplate();
	        String apiUrl = "https://api.iamport.kr/users/getToken";
	        
	        System.out.println(tokenRequest);
	        
	        System.out.println("getAccessToken서비스 오나욜");
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
	        map.add("imp_key", tokenRequest.getImp_key());
	        map.add("imp_secret", tokenRequest.getImp_secret());
	        
	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
	        
	        System.out.println("서비스 리퀘스으0" + request);

	        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
	        
	        // 아마도 반환 형식의 문제가 발생할 수 있습니다.
	        // String 으로 결과를 얻었을 경우, 해당 문자열을 반환하도록 수정
	        return response.getBody();
        }

    public ResponseEntity<String> getHolderInformation(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.iamport.kr/vbanks/holder";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity, String.class);
    }


    
}
