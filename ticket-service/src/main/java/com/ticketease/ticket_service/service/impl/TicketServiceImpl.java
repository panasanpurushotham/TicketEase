package com.ticketease.ticket_service.service.impl;

import com.ticketease.ticket_service.entity.Ticket;
import com.ticketease.ticket_service.mapper.DtoToEntityMapper;
import com.ticketease.ticket_service.repository.TicketRepository;
import com.ticketease.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl  {
    @Autowired
    private DtoToEntityMapper mapper;
    @Autowired
    private TicketRepository ticketRepository;


    public Ticket bookTicket(Ticket ticket) {
        // Implement booking logic here (e.g., set booking date, validate inputs, save to repository)
        ticket.setBookingDate(new Date());
        Ticket bookTicket = ticketRepository.save(ticket);  // Save ticket to repository
        return bookTicket;
    }


    public void cancelTicket(Long ticketId) {
        // Implement cancel logic here (e.g., find ticket by ID, update status
        ticketRepository.deleteById(ticketId);

    }


    public List<Ticket> getBookingHistory(Long userId) {
        // Implement history retrieval logic here (e.g., find tickets by user ID)
        List<Ticket> bookingHistory = ticketRepository.findByUserId(userId);
        return bookingHistory;
    }


    public int getAvailableSeats(Long movieId, String showtime) {
        int availableSeats = 50;  // Example: Replace with actual logic to find available seats
        return availableSeats;

    }

    public String selectSeats(Long movieId, String showtime, List<String> selectedSeats) {
        String confirmationCode = "ABC123";  // Example: Replace with actual logic to generate confirmation code
        return confirmationCode;

    }
}
