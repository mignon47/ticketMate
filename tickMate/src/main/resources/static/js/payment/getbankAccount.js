/* import { generateOrderNum } from './generateOrderNum';

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
            const vbankDue = document.getElementById('vbank_due').value;
            const access_token = 'Bearer ' + accessToken;
            console.log(access_token);
            console.log(merchant_uid);
            console.log(vbankCode);
            
            const pg_api_key = 'ItEQKi3rY7uvDS8l';
            
            const requestData = {
                vbank_code: vbankCode, 
                userName: userName, // 가상계좌 예금주 이름
                merchant_uid: merchant_uid, // 가맹점에서 사용하는 고유한 주문번호
                amount: amount, // 결제 금액
                vbank_due: vbankDue, // 가상계좌 만료일
                pg_api_key: pg_api_key
            };
            
             fetch('/vbanks', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': access_token  // 프론트엔드에서 얻은 토큰을 HTTP Header의 Authorization으로 보냄
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

*/