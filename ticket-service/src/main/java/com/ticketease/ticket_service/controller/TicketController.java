package com.ticketease.ticket_service.controller;


import com.ticketease.ticket_service.entity.Ticket;
import com.ticketease.ticket_service.service.TicketService;
import com.ticketease.ticket_service.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

//    @Autowired
//    private TicketService ticketService;

    @Autowired
    private TicketServiceImpl ticketService;

    // Endpoint to book a ticket
    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticketDTO) {
        Ticket bookedTicket = ticketService.bookTicket(ticketDTO);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    // Endpoint to cancel a ticket by ID
    @DeleteMapping("/cancel/{ticketId}")
    public ResponseEntity<Void> cancelTicket(@PathVariable Long ticketId) {
        ticketService.cancelTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to retrieve booking history for a user
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Ticket>> getBookingHistory(@PathVariable Long userId) {
        List<Ticket> bookingHistory = ticketService.getBookingHistory(userId);
        return new ResponseEntity<>(bookingHistory, HttpStatus.OK);
    }

    // Endpoint to check available seats for a showtime
    @GetMapping("/seats/available")
    public ResponseEntity<Integer> getAvailableSeats(@RequestParam Long movieId, @RequestParam String showtime) {
        int availableSeats = ticketService.getAvailableSeats(movieId, showtime);
        return new ResponseEntity<>(availableSeats, HttpStatus.OK);
    }

    // Endpoint to select seats during booking
    @PostMapping("/seats/select")
    public ResponseEntity<String> selectSeats(@RequestParam Long movieId, @RequestParam String showtime, @RequestParam List<String> selectedSeats) {
        String selectionResult = ticketService.selectSeats(movieId, showtime, selectedSeats);
        return new ResponseEntity<>(selectionResult, HttpStatus.OK);
    }
}

