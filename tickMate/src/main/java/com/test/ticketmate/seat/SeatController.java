package com.test.ticketmate.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/{id}")
    public Seat getSeat(@PathVariable Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Seat addSeat(@RequestBody Seat seat) {
        return seatRepository.save(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat updatedSeat) {
        Seat seat = seatRepository.findById(id).orElse(null);
        if (seat != null) {
            seat.setSeatNum(updatedSeat.getSeatNum());
            seat.setSeatRow(updatedSeat.getSeatRow());
            seat.setSeatNumber(updatedSeat.getSeatNumber());
            seat.setSeatStatus(updatedSeat.isSeatStatus());
            return seatRepository.save(seat);
        } else {
            return null;
        }
    }

    @GetMapping("/all")
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}

