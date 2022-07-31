package com.kumar.webflux.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kumar.webflux.dao.CustomerDao;
import com.kumar.webflux.dao.repository.CustomerRepository;
import com.kumar.webflux.dto.Customer;
import com.kumar.webflux.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	private CustomerDao dao;
	private CustomerRepository repository;

	public CustomerService(CustomerDao dao, //
			CustomerRepository repository) {
		this.dao = dao;
		this.repository = repository;

	}

	public List<Customer> loadAllCustomers() {
		long start = System.currentTimeMillis();
		List<Customer> customers = dao.getCustomers();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return customers;
	}

	public Flux<Customer> loadAllCustomersStream() {
		long start = System.currentTimeMillis();
		Flux<Customer> customers = dao.getCustomersStream();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return customers;
	}

	public Flux<com.kumar.webflux.dto.Customer> getCustomers() {
		return repository.findAll().map(AppUtils::entityToDTO);
	}

	public Mono<com.kumar.webflux.dto.Customer> getCustomer(String id) {
		return repository.findById(id).map(AppUtils::entityToDTO);
	}

	public Mono<com.kumar.webflux.dto.Customer> saveCustomer(Mono<com.kumar.webflux.dto.Customer> customer) {
		return customer//
				.map(AppUtils::dtoToentity)// converting from request to entity
				.flatMap(repository::insert)// saving the entity
				.map(AppUtils::entityToDTO); // converting entity to DTO
	}
}
