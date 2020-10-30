package com.microservice.ticketservice.service;

import com.microservice.ticketservice.dto.TicketDto;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author erayy
 */

public interface TicketService {

    TicketDto getById(String id);

    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id, TicketDto ticketDto);

    Page<TicketDto> getPagination(Pageable pageable);

    //List<TicketDto> findAll(Pageable pageable);
}
