package com.ticketease.ticket_service.service;


import com.ticketease.ticket_service.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Ticket ticket);

    void cancelTicket(Long ticketId);

    List<Ticket> getBookingHistory(Long userId);

    int getAvailableSeats(Long movieId, String showtime);

    String selectSeats(Long movieId, String showtime, List<String> selectedSeats);


}

