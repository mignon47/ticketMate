/*
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById('bankInfoForm').addEventListener('submit', function(event) {
	    event.preventDefault();
	    getAccessTokenAndProcessData(); // 폼 제출 시 토큰 가져오기 및 데이터 처리 함수 호출
	});
});	
*/

function getAccessToken() {
    let accessToken = ''; // 토큰을 안전하게 저장

    fetch('/getAccessToken')
        .then(response => response.text())
        .then(data => {
            accessToken = data; // 받은 토큰을 저장
            
            console.log('accessToken :', accessToken);
            
            // 여기에서 토큰을 사용한 데이터 처리나 다른 API 호출 등을 수행할 수 있음
            const bankCode = document.getElementById('bankCode').value;
            const bankAccountNumber = document.getElementById('bankAccountNumber').value;

            fetch(`/checkBankHolder?bank_code=${bankCode}&bank_num=${bankAccountNumber}`, {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${accessToken}`
                }
            })
            .then(response => response.json())
            .then(data => {
                console.log('API 응답:', data);
                console.log('bankCode', bankCode);
                console.log('bankAccountNumber', bankAccountNumber);
                console.log('accessToken', accessToken);
                // 데이터 처리 또는 표시
            })
            .catch(error => {
                console.error('API 요청 중 에러:', error);
            });
            
            
        })
        .catch(error => {
            console.error('에러:', error);
            document.getElementById('tokenResponse').innerText = '토큰을 받는 도중 에러 발생';
        });
}
