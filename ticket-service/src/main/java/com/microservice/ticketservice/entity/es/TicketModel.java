package com.microservice.ticketservice.entity.es;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author erayy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Document(indexName = "ticket" )
public class TicketModel implements Serializable {

    @Id
    private String id;

    private String description;

    private String notes;

    //account
    private String assignee;

    private Date ticketDate;

    private String priorityType;


    private String ticketStatus;

}
