package com.async.rest.service;

import org.springframework.util.concurrent.ListenableFuture;

import com.async.rest.model.CountryDTO;

public interface IRepositoryService {
	ListenableFuture<CountryDTO> search();

}
