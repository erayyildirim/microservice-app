package com.microservice.ticketservice.service.impl;

import com.microservice.ticketservice.dto.TicketDto;
import com.microservice.ticketservice.entity.PriorityType;
import com.microservice.ticketservice.entity.Ticket;
import com.microservice.ticketservice.entity.TicketStatus;
import com.microservice.ticketservice.entity.es.TicketModel;
import com.microservice.ticketservice.repo.TicketRepository;
import com.microservice.ticketservice.repo.es.TicketElasticRepository;
import com.microservice.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author erayy
 */
@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final ModelMapper modelMapper;

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        if (ticketDto.getDescription() == null) {
            throw new IllegalArgumentException("Description can not be null");
        }
        Ticket ticket = new Ticket();

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        //ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        ticket = ticketRepository.save(ticket);


        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                //.assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        ticketElasticRepository.save(model);

        ticketDto.setId(ticket.getId());
        return null;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
