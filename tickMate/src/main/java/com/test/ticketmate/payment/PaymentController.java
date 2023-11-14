package com.test.ticketmate.payment;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.ticketmate.member.Member;
import com.test.ticketmate.member.MemberController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller	
public class PaymentController {
	
	private final MemberController memberController;
    private final PaymentService paymentService;
	
    @GetMapping("/paymentTest")
    public String paymentTest() {
    	return "payment/paymentTest";
    }
	
    @GetMapping("/getAccessToken") // 토큰 호출 
    @ResponseBody
    public String getAccessToken() {
        String imp_key = "5740138844584536"; // API Key
        String imp_secret = "nGjXCeHpA64p2BiXb1aXSwN9cVWbAEJJ6eUvpcyz47oJFlBiBfw2ipB133Ohovq45PdHBUhEALiCAzLl"; // secret
        
        System.out.println("getAccessToken 오는지");
        
        TokenRequest request = new TokenRequest(imp_key, imp_secret);

        String response = paymentService.getAccessToken(request);
        
        System.out.println("컨트롤러 - resopnse : " + response);
        
        return response;
    }
    
	/* api 작업중 ,, 일단 흐린 눈 해주세요,,,
	 * @GetMapping("/checkBankHolder") public ResponseEntity<String>
	 * checkBankHolder(
	 * 
	 * @RequestParam("bank_code") String bankCode,
	 * 
	 * @RequestParam("bank_num") String bank_num,
	 * 
	 * @RequestHeader("Authorization") String accessToken ) {
	 * 
	 * System.out.println("컨트롤러 checkBankHolder"); System.out.println("bank_code : "
	 * + bankCode); System.out.println("bank_num : " + bank_num);
	 * System.out.println("Authorization : " + accessToken);
	 * 
	 * String apiUrl = "https://api.iamport.kr/vbanks/holder";
	 * 
	 * // 필수 코드 은행코드 (필수) bank_code: string / 계좌번호 (필수) bank_num: string String
	 * queryString = String.format("bank_code=%s&bank_num=%s", bankCode, bank_num);
	 * 
	 * // System.out.println("queryString: " + queryString);
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.set("Authorization",
	 * "Bearer " + accessToken); headers.setContentType(MediaType.APPLICATION_JSON);
	 * 
	 * UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
	 * .query(queryString);
	 * 
	 * HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	 * 
	 * ResponseEntity<String> response = new RestTemplate().exchange(
	 * builder.toUriString(), HttpMethod.GET, requestEntity, String.class );
	 * 
	 * return response; }
	 */
    
    // 주문 - 결제 페이지 
    @GetMapping("/payment")
    public String payment(HttpSession session, Model model) {
    	
    	Member member = (Member) session.getAttribute("user");
    	
    	int memberNum = member.getMemberNum();
    	session.setAttribute("memberNum", memberNum);
    	model.addAttribute("memberNum", memberNum);
    	
    	model.addAttribute("member", member);
        
    	System.out.println(memberNum);
    	
    	return "payment/payment"; 
    }

}
