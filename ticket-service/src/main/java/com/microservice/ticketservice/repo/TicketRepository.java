package com.microservice.ticketservice.repo;

import com.microservice.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erayy
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {
}
