package com.kumar.webflux.service;

import org.springframework.stereotype.Service;

import com.kumar.webflux.repository.CustomerRepository;
import com.kumar.webflux.utils.TransformerUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	private CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;

	}


	public Flux<com.kumar.webflux.dto.Customer> getCustomers() {
		return repository.findAll().map(TransformerUtils::entityToDTO);
	}

	public Mono<com.kumar.webflux.dto.Customer> getCustomer(String id) {
		return repository.findById(id).map(TransformerUtils::entityToDTO);
	}

	public Mono<com.kumar.webflux.dto.Customer> saveCustomer(Mono<com.kumar.webflux.dto.Customer> customer) {
		return customer//
				.map(TransformerUtils::dtoToentity)// converting from request to entity
				.flatMap(repository::insert)// saving the entity
				.map(TransformerUtils::entityToDTO); // converting entity to DTO
	}

	public Mono<com.kumar.webflux.dto.Customer> updateCustomer(//
			Mono<com.kumar.webflux.dto.Customer> customer, //
			String id) {

		return repository.findById(id)//
				.flatMap(c -> customer.map(TransformerUtils::dtoToentity)//
						.doOnNext(e -> e.setId(id)))//
				.flatMap(repository::save).map(TransformerUtils::entityToDTO);
	}

	public Mono<Void> deleteCustomer(String id) {
		return repository.deleteById(id);
	}
}
