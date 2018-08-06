package com.async.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import com.async.rest.model.CountryDTO;
import com.async.rest.model.CountryRestResponse;

@Service
public class RepositoryService implements IRepositoryService {

	private static final String SEARCH_URL = "http://services.groupkt.com/country/get/all";

	@Autowired
	private AsyncRestTemplate asyncRestTemplate;

	@Override
	public ListenableFuture<CountryDTO> search() {
		ListenableFuture<ResponseEntity<CountryRestResponse>> countries = asyncRestTemplate.getForEntity(SEARCH_URL,
				CountryRestResponse.class);
		ListenableFuture repositoryListDtoAdapter = new RepositoryListDtoAdapter(countries);
		return repositoryListDtoAdapter;
	}
}
