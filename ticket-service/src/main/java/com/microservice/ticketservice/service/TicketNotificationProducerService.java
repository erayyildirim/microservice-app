package com.microservice.ticketservice.service;

import com.microservice.ticketservice.entity.Ticket;

/**
 * @author erayy
 */
public interface TicketNotificationProducerService {

    void sendToQueue(Ticket ticket);
}
