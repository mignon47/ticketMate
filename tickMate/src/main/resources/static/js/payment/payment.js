/*******************************************/
// 주문번호 생성(m-uid)
function generateOrderNum() {
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    
    // 현재 시간을 밀리초로 가져와 난수로 사용
    const randomNum = Math.floor(Math.random() * 10000);

    const orderNumber =Number(`${year}${month}${day}${randomNum}`);
    
    return orderNumber;
}

/*******************************************/
// vbank_due 입금 기한 날짜 설정 
var currentDate = new Date();

currentDate.setDate(currentDate.getDate() + 3);

// 원하는 형식으로 날짜 포맷팅 (YYYYMMDD)
var formattedDate = currentDate.getFullYear() +
    ('0' + (currentDate.getMonth() + 1)).slice(-2) +
    ('0' + currentDate.getDate()).slice(-2);

// 결과 확인
console.log(formattedDate);

/*******************************************/
// 결제 - 토큰 필요 x 
  var IMP = window.IMP;
      IMP.init("imp54524187");
 
      function requestPay() {
      
      	var memberName = document.getElementById('member_name').value;
      	var memberEmail = document.getElementById('member_email').value;
      	var memberPhone = document.getElementById('member_phone').value;
      	var memberPost = document.getElementById('member_post').value;
      	var memberAddress = document.getElementById('member_address').value;
      	var performNum = document.getElementById('perform_num').value;
		var quantity = parseInt(document.getElementById('quantity').value);
		var price = parseInt(document.getElementById('price').value);
      	var memberNum = document.getElementById('member_num').value;
		
		console.log('memberEmail', memberEmail);
		
      	// 결제 - 토큰 필요 x 
  var IMP = window.IMP;
      IMP.init("imp54524187");
 
      function requestPay() {
      
      	var memberName = document.getElementById('member_name').value;
      	var memberEmail = document.getElementById('member_email').value;
      	var memberPhone = document.getElementById('member_phone').value;
      	var memberPost = document.getElementById('member_post').value;
      	var memberAddress = document.getElementById('member_address').value;
      	var performNum = document.getElementById('perform_num').value;
		var quantity = parseInt(document.getElementById('quantity').value);
		var price = parseInt(document.getElementById('price').value);
      	
      	// 결제방식 선택 - 카드 / 계좌
      	var paymentForm = document.getElementById('paymentForm');
    	var paymentMethod = paymentForm.querySelector('input[name="paymentMethod"]:checked').value;
      	
      	const orderNum = generateOrderNum();
      	console.log(orderNum);
      	console.log('performNum',performNum);
      	console.log('quantity',quantity);
      	console.log('price',price);
      	console.log('memberNum',memberNum);
      	
      	const paymentInfo = {
	       	pg: "kcp.{INIpayTest}",
	        pay_method: paymentMethod,
	        merchant_uid : orderNum.toString(),
	        name: "당근 10kg",
	        amount: price,
	        buyer_email: memberEmail,
	        buyer_name: memberName,
	        buyer_tel: memberPhone,
	        buyer_addr: memberAddress,
	        buyer_postcode: memberPost,
	      //  vbank_due: formattedDate
	    };
    	
    	const paymentParams = new URLSearchParams({
		    orderNum: orderNum,
		    memberName: memberName,
		    memberEmail: memberEmail,
		    memberPhone: memberPhone,
		    memberAddress: memberAddress,
		    memberPost: memberPost,
		    price : price,
		    quantity : quantity,
		    memberNum: memberNum,
		    performNum : performNum
		}); 
    	
    	console.log('paymentParams',paymentParams);
    	
    	IMP.request_pay(paymentInfo, function (rsp) {
        if (rsp.success) {
            console.log('결제 성공');
            console.log('주문 번호:', orderNum);
            console.log('결제 수단:', rsp.pay_method);
            
	          $.ajax({
	            type: 'POST',
	            url: '/paySuccess',  
	            contentType: 'application/json',
	            data: JSON.stringify({
	                orderNum: paymentInfo.merchant_uid,
	                payMethod: rsp.pay_method,
	                price : price,
	                quantity: quantity,
	                memberNum: memberNum,
	                performNum : performNum,
	                memberName: memberName,
				    memberEmail: memberEmail,
				    memberPhone: memberPhone,
				    memberAddress: memberAddress,
				    memberPost: memberPost,
	            }),
	            success: function (data) {
	                console.log('주문 정보 전송 완료:', data);
	            },
	            error: function (error) {
	                console.error('주문 정보 전송 실패:', error);
	            }
	        });
		  } else {
            console.log('결제 실패', rsp.error_msg);
        }
    });
}	 
      	
      	// 결제방식 선택 - 카드 / 계좌
      	var paymentForm = document.getElementById('paymentForm');
    	var paymentMethod = paymentForm.querySelector('input[name="paymentMethod"]:checked').value;
      	
      	const orderNum = generateOrderNum();
      	console.log(orderNum);
      	console.log('performNum',performNum);
      	console.log('quantity',quantity);
      	console.log('price',price);
      	console.log('memberNum',memberNum);
      	
      	const paymentInfo = {
	       	pg: "kcp.{INIpayTest}",
	        pay_method: paymentMethod,
	        merchant_uid : orderNum.toString(),
	        name: "당근 10kg",
	        amount: price,
	        buyer_email: memberEmail,
	        buyer_name: memberName,
	        buyer_tel: memberPhone,
	        buyer_addr: memberAddress,
	        buyer_postcode: memberPost,
	      //  vbank_due: formattedDate
	    };
    	
    	IMP.request_pay(paymentInfo, function (rsp) {
        if (rsp.success) {
        	console.log('paymentInfo', paymentInfo);
            console.log('결제 성공');
            console.log('주문 번호:', orderNum);
            console.log('결제 수단:', rsp.pay_method);
            
	          $.ajax({
	            type: 'POST',
	            url: '/paySuccess',  
	            contentType: 'application/json',
	            data: JSON.stringify({
	                orderNum: paymentInfo.merchant_uid,
	                payMethod: rsp.pay_method,
	                price : price,
	                quantity: quantity,
	                memberNum: memberNum,
	                memberName : paymentInfo.buyer_name,
	                memberEmail : paymentInfo.buyer_email,
	                memberPhone : paymentInfo.buyer_tel,
	                memberAddress : paymentInfo.buyer_addr,
	                memberPost : paymentInfo.buyer_postcode,
	              //  performNum : performNum
	            }),
	            success: function (data) {
		             console.log('AJAX 요청 데이터:', JSON.stringify({
	            	 orderNum: paymentInfo.merchant_uid,
	            	 payMethod: rsp.pay_method,
	            	 price: price,
	           		 quantity: quantity,
	            	// performNum: performNum,
	        	}));
	        	  	console.log('order 객체 내용:', data);
	                console.log('주문 정보 전송 완료:', data);
	                // 추가로 필요한 로직 수행
	            },
	            error: function (error) {
	                console.error('주문 정보 전송 실패:', error);
	            }
	        });
		  } else {
            console.log('결제 실패', rsp.error_msg);
        }
    });
}	 






/*	
        IMP.request_pay( // 멤버정보랑 수정 예정 
          {
            pg: "kcp.{INIpayTest}",
            pay_method: paymentMethod,
            merchant_uid: orderNum,
            name: "당근 10kg",
            amount: 100,
            buyer_email: memberEmail,
            buyer_name: memberName,
            buyer_tel: memberPhone,
            buyer_addr: memberAddress,
            buyer_postcode: memberPost,
           // m_redirect_url : "payment/paymentTest", // 모바일 전송
           // escrow : true,
            vbank_due : formattedDate // 오늘날짜 +3일기준 
          }, 
          
          
          
          
          function (rsp) {
          if (rsp.success) {
             console.log('결제 성공');
             console.log('결제 수단:', rsp.pay_method);

	            // pay_method에 따른 분기 처리
	            if (rsp.pay_method === 'card') {
	                console.log('카드 결제 로직');
	                alert("결제가 완료되었습니다.");
	                var vbankInsert = '/paySuccess'; <-- 결제 성공 로직 필요 
	                
	                
	                
	                
	            } else if (rsp.pay_method === 'vbank') {
	                console.log('가상계좌 결제 로직');
	                
	                var vbankInsert = '/paySuccess';
	                
	                
	                
	                
	            }
	            
	            // ... (결제 성공 후 추가 로직) ...
	        } else {
	            // 결제 실패 시 로직
	            console.log('결제 실패');
	            alert("결제에 실패하였습니다.");
	            // ... (결제 실패 시 추가 로직) ...
	        }
         });
     }
*/


/////////////////API 시도중//////////////    
// 나중에 화면 출력할때는 YYYYMMDD로 바꿔서 출력할 것 
function formatDateToYYYYMMDD(days) {
    const currentDate = new Date();
    const targetDate = new Date(currentDate.getTime() + days * 24 * 60 * 60 * 1000);
	return Math.floor(targetDate.getTime() / 1000); 
}
  
// 토큰발급 및 가상계좌 생성       
function getAccessTokenAndCreateVBankAccount() {
	
 	// 토큰 발급
    fetch('/getAccessToken')
        .then(response => response.json())
        .then(data => {
        	 if (data && data.response && data.response.access_token) {
                console.log('accessToken :', data.response.access_token);
                createVBankAccount(data.response.access_token);
            } else {
                console.error('토큰 요청 결과의 access_token이 유효하지 않습니다.');
            }
        })
        .catch(error => {
            console.error('토큰 요청 중 에러:', error);
        });
}

// 가상 계좌 생성 함수
function createVBankAccount(accessToken) {

			console.log('createVBankAccount :', accessToken);
            // 가상계좌 생성
            const vbankCode = document.getElementById('vbank_code').value; // 수정된 부분
            const userName = document.getElementById('userName').value; // 수정된 부분
            const merchant_uid = generateOrderNum();
            const amount = document.getElementById('amount').value;
            const vbankDue = formatDateToYYYYMMDD(3); // 입금 기한 설정 +3일
            const access_token = 'Bearer ' + accessToken; // 토큰
            
            // document.getElementById('vbank_due').value = vbankDue;
            //const vbankDue = document.getElementById('vbank_due').value;
            
            console.log(access_token);
            console.log(merchant_uid);
            console.log(vbankCode);
            
            
            const requestData = {
                vbank_code: vbankCode, 
                userName: userName, 
                merchant_uid: merchant_uid, 
                amount: amount, 
                vbank_due: vbankDue, 
             //   pg_api_key: pg_api_key
            };
            
             fetch('/vbanks', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': access_token 
                },
                body: JSON.stringify(requestData)
            })
            .then(response => response.json())
            .then(data => {
                console.log('가상계좌 생성 응답:', data);
                 if (data && data.error) {
			        // 서버에서 에러 응답을 보냈을 때 처리하는 로직
			        console.error('서버에서 오류 응답:', data.error);
			        console.log('data:',data);
			        console.log('access_token:',access_token);
		        // 이 부분에서 사용자에게 오류를 보여줄 수 있음
		      } else {
		        // 반환된 데이터를 정상적으로 처리하는 로직
		        console.log('가상계좌 생성 응답:', data);
		        // 여기에서 반환된 데이터를 처리하거나 화면에 표시할 수 있습니다.
		      }
                // 여기에서 반환된 데이터를 처리하거나 화면에 표시할 수 있습니다.
            })
            .catch(error => {
                console.error('가상계좌 생성 중 에러:', error);
            });
}      