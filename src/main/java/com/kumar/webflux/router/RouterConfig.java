package com.kumar.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.kumar.webflux.handler.CustomerHandler;
import com.kumar.webflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {

	private CustomerHandler handler;
	private CustomerStreamHandler streamHandler;

	public RouterConfig(CustomerHandler handler, CustomerStreamHandler streamHandler) {
		this.handler = handler;
		this.streamHandler = streamHandler;

	}

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {//
		return RouterFunctions.route().GET("/router/customers", handler::loadCustomers)//
				.GET("/router/customers/stream", streamHandler::getCustomers)//
				.GET("/router/v1/customers/stream", streamHandler::customers)//
				.GET("/router/customer/{input}", handler::findCustomer)//
				.POST("/router/customer/save", handler::saveCustomer)//
				.POST("/router/customer/v1/save", streamHandler::saveCustomer)//
				.build();

	}
}
