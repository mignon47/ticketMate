document.addEventListener("DOMContentLoaded", function() {
    var seatTable = document.getElementById("seat-table");

    // 구역, 행, 열 수 설정
    var numSections = 5; // 총 5개의 구역
    var rowsPerSection = 10; // 각 구역당 10행
    var colsPerRow = 20; // 각 행당 20열

    // 좌석 생성 및 배치
    for (var section = 1; section <= numSections; section++) {
        var sectionHeader = document.createElement("tr");
        var headerCell = document.createElement("td");
        headerCell.textContent = "구역 " + section;
        headerCell.setAttribute("colspan", colsPerRow);
        sectionHeader.appendChild(headerCell);
        seatTable.appendChild(sectionHeader);

        for (var row = 0; row < rowsPerSection; row++) {
            var rowLetter = String.fromCharCode(65 + row); // A, B, C, ...
            var seatRow = document.createElement("tr");

            for (var col = 1; col <= colsPerRow; col++) {
                var seat = document.createElement("td");
                seat.textContent = rowLetter + col;
                seat.className = "seat";
                seatRow.appendChild(seat);
            }

            seatTable.appendChild(seatRow);
        }
    }

    // 좌석 선택 및 예매 기능 추가 (선택 버튼 등)
    // 이 부분은 필요에 따라 추가하실 수 있습니다.
});
