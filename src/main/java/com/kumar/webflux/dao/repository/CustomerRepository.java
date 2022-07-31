package com.kumar.webflux.dao.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.kumar.webflux.entity.Customer;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String>  {

}
