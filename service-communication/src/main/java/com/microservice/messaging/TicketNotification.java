package com.microservice.messaging;

import lombok.*;

/**
 * @author erayy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TicketNotification {

    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
