package com.kumar.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.kumar.webflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {

	private CustomerStreamHandler streamHandler;

	public RouterConfig(CustomerStreamHandler streamHandler) {
		this.streamHandler = streamHandler;

	}

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {//
		return RouterFunctions.route()//
				.GET("/router/customers/v1/", streamHandler::getCustomers)//
				.POST("/router/customer/v1/save", streamHandler::saveCustomer)//
				.build();

	}
}
