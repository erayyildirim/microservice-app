package com.microservice.ticketservice.entity;

import lombok.Getter;

/**
 * @author erayy
 */

@Getter
public enum TicketStatus {
    OPEN("Açık"), IN_PROGRESS("Çalışılıyor"), RESOLVED("Çözüldü"), CLOSED("Kapandı");

    private String label;

    TicketStatus(String label) {
        this.label = label;
    }}
