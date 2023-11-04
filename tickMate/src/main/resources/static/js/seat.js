document.addEventListener("DOMContentLoaded", function() {
    var selectedSeats = [];
    var seatTable = document.getElementById("seat-table");

    // 행과 열 수 설정
    var numRows = 20; // 행 수 (A, B, C, ...)
    var numCols = 50; // 열 수 (1, 2, 3, ...)

    // 행 생성
    for (var i = 0; i < numRows; i++) {
        var row = document.createElement("tr");
        
        // 각 행에 열(좌석) 추가
        for (var j = 0; j < numCols; j++) {
            var seat = document.createElement("td");
            seat.textContent = String.fromCharCode(65 + i) + (j + 1); // A, B, C, ... + 1, 2, 3, ...
            seat.className = "seat";
            row.appendChild(seat);
        }
        
        seatTable.appendChild(row);
    }

    document.querySelectorAll(".seat").forEach(function(seat) {
        seat.addEventListener("click", function() {
            seat.classList.toggle("selected");
            var seatNumber = seat.textContent;

            if (selectedSeats.includes(seatNumber)) {
                selectedSeats = selectedSeats.filter(item => item !== seatNumber);
            } else {
                selectedSeats.push(seatNumber);
            }
        });
    });

    document.getElementById("book-button").addEventListener("click", function() {
        if (selectedSeats.length > 0) {
            alert("선택한 좌석: " + selectedSeats.join(", "));
        } else {
            alert("좌석을 선택하세요.");
        }
    });
});
