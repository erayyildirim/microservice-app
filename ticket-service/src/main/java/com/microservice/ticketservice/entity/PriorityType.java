package com.microservice.ticketservice.entity;

import lombok.Getter;

/**
 * @author erayy
 */

@Getter
public enum PriorityType {
    URGENT("Acil"), LOW("Önemsiz"), HIGH("Öncelikli");

    private String label;

    PriorityType(String label) {
        this.label = label;
    }}
