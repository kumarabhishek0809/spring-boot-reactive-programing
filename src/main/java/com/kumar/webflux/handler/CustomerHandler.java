package com.kumar.webflux.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.kumar.webflux.dao.CustomerDao;
import com.kumar.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	private CustomerDao dao;

	public CustomerHandler(CustomerDao dao) {
		this.dao = dao;
	}

	public Mono<ServerResponse> loadCustomers(ServerRequest request) {
		Flux<Customer> customerList = dao.getCustomerList();
		return ServerResponse.ok().body(customerList, Customer.class);
	}

	public Mono<ServerResponse> findCustomer(ServerRequest request) {
		int customerId = Integer.valueOf(request.pathVariable("input"));
		Mono<Customer> customerMono = dao.getCustomerList()//
				.filter(c -> c.getId().equals(customerId)).next();
		return ServerResponse.ok().body(customerMono, Customer.class);
	}

	public Mono<ServerResponse> saveCustomer(ServerRequest request) {
		Mono<Customer> customerMono = request.bodyToMono(Customer.class);
		Mono<String> saveResponse = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
		return ServerResponse.ok().body(saveResponse, String.class);
	}

}
