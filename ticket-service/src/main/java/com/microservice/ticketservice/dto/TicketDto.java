package com.microservice.ticketservice.dto;

import com.microservice.ticketservice.entity.PriorityType;
import com.microservice.ticketservice.entity.TicketStatus;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author erayy
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String notes;

    //account
    @Getter
    @Setter
    private String assignee;

    @Getter
    @Setter
    private Date ticketDate;

    @Getter
    @Setter
    private String priorityType;

    @Getter
    @Setter
    private String ticketStatus;
}
