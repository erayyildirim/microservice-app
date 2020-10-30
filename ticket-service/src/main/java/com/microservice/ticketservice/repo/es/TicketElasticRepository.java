package com.microservice.ticketservice.repo.es;

import com.microservice.ticketservice.entity.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author erayy
 */
public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}
