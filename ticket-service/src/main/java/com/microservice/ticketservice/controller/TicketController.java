package com.microservice.ticketservice.controller;

import com.microservice.ticketservice.dto.TicketDto;
import com.microservice.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author erayy
 */
@RequiredArgsConstructor
@RequestMapping("/ticket")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.update(id, ticketDto));
    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }
}
