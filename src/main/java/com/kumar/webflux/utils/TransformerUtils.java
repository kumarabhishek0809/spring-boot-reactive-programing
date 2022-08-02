package com.kumar.webflux.utils;

import com.kumar.webflux.entity.Customer;

public class TransformerUtils {

	private TransformerUtils() {

	}

	public static com.kumar.webflux.dto.Customer entityToDTO(Customer customerEntity) {
		return com.kumar.webflux.dto.Customer//
				.builder()//
				.id(customerEntity.getId()) //
				.name(customerEntity.getName())//
				.build();
	}
	
	public static Customer dtoToentity(com.kumar.webflux.dto.Customer customerDTO) {
		return Customer//
				.builder()//
				.id(customerDTO.getId()) //
				.name(customerDTO.getName())//
				.build();
	}

}
