package com.ticketease.ticket_service.service.impl;

import com.ticketease.ticket_service.entity.Ticket;
import com.ticketease.ticket_service.mapper.DtoToEntityMapper;
import com.ticketease.ticket_service.repository.TicketRepository;
import com.ticketease.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private DtoToEntityMapper mapper;
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public Ticket bookTicket(Ticket ticket) {
        // Implement booking logic here (e.g., set booking date, validate inputs, save to repository)

    }

    @Override
    public void cancelTicket(Long ticketId) {
        // Implement cancel logic here (e.g., find ticket by ID, update status
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public List<Ticket> getBookingHistory(Long userId) {
        // Implement history retrieval logic here (e.g., find tickets by user ID)

    }
    @Override
    public int getAvailableSeats(Long movieId, String showtime) {

    }

    @Override
    public String selectSeats(Long movieId, String showtime, List<String> selectedSeats) {

    }
}
