package com.microservice.ticketservice.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author erayy
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @CreatedBy
    @Column(name = "created_by")
    private Date createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


}
