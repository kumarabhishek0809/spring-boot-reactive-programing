package com.async.rest.service;

import org.springframework.util.concurrent.ListenableFuture;

import com.async.rest.model.CountryDTO;

import java.util.List;

public interface IRepositoryService {
	ListenableFuture<List<CountryDTO>> asyncSearch();
	List<CountryDTO>  syncSearch();

}
