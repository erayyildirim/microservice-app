package com.microservices.accountservice.repo;

import com.microservices.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erayy
 */
@Repository
public interface AccountRepo extends CassandraRepository<Account, String> {

}
