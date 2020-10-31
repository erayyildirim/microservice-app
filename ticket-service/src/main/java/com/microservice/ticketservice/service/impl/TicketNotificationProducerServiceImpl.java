package com.microservice.ticketservice.service.impl;

import com.microservice.messaging.TicketNotification;
import com.microservice.ticketservice.entity.Ticket;
import com.microservice.ticketservice.service.TicketNotificationProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author erayy
 */
@Service
@RequiredArgsConstructor
@EnableBinding(Source.class)
public class TicketNotificationProducerServiceImpl implements TicketNotificationProducerService {

    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = TicketNotification.builder()
                .ticketId(ticket.getId())
                .accountId(ticket.getAssignee())
                .ticketDescription(ticket.getDescription())
                .build();

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
