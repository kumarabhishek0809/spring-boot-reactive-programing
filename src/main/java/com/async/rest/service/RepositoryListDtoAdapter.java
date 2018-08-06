package com.async.rest.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import com.async.rest.model.CountryDTO;
import com.async.rest.model.CountryRestResponse;

public class RepositoryListDtoAdapter extends ListenableFutureAdapter<List<CountryDTO>, ResponseEntity<CountryRestResponse>>   {

    public RepositoryListDtoAdapter(ListenableFuture<ResponseEntity<CountryRestResponse>> countryRestResponse) {
    	super(countryRestResponse);
	}

	@Override
	protected List<CountryDTO> adapt(ResponseEntity<CountryRestResponse> adapteeResult) throws ExecutionException {
		 CountryRestResponse responseBody = adapteeResult.getBody();
		 return responseBody.getResult();
	}

  
}