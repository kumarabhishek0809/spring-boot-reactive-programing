package com.kumar.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.kumar.webflux.dto.Customer;
import com.kumar.webflux.service.CustomerService;

import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

	private CustomerService service;

	public CustomerStreamHandler(CustomerService service) {
		this.service = service;
	}

	public Mono<ServerResponse> getCustomers(ServerRequest request) {
		return ServerResponse.ok()//
				.contentType(MediaType.TEXT_EVENT_STREAM)//
				.body(service.getCustomers(), Customer.class);
	}

	public Mono<ServerResponse> saveCustomer(ServerRequest request) {
		System.out.println("controller method called ...");
		return ServerResponse.ok()//
				.contentType(MediaType.TEXT_EVENT_STREAM)//
				.body(service.saveCustomer//
				(request.bodyToMono(com.kumar.webflux.dto.Customer.class))//
						, Customer.class);
	}

}
