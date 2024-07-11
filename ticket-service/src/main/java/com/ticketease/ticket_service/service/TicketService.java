package com.ticketease.ticket_service.service;


import com.ticketease.ticket_service.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Ticket ticket);

    void cancelTicket(Long Id);

    List<Ticket> getBookingHistory(Long user_id);

    int getAvailableSeats(Long movie_id, String showtime);

    String selectSeats(Long movieId, String showtime, List<String> selectedSeats);


}

