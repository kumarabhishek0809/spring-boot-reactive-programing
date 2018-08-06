package com.async.rest.service;

import com.async.rest.model.CountryDTO;
import com.async.rest.model.CountryRestResponse;
import com.async.rest.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RepositoryService implements IRepositoryService {

    private static final String SEARCH_URL = "http://services.groupkt.com/country/get/all";

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ListenableFuture<List<CountryDTO>> asyncSearch() {
        ListenableFuture<ResponseEntity<CountryRestResponse>> countries = asyncRestTemplate.getForEntity(SEARCH_URL,
                CountryRestResponse.class);
        ListenableFuture repositoryListDtoAdapter = new RepositoryListDtoAdapter(countries);
        return repositoryListDtoAdapter;
    }

    @Override
    public List<CountryDTO> syncSearch() {
        ResponseEntity<CountryRestResponse> countries = restTemplate.getForEntity(SEARCH_URL,
                CountryRestResponse.class);
        CountryRestResponse body = countries.getBody();
        RestResponse restResponse = body.getRestResponse();
        List<CountryDTO> result = restResponse.getResult();
        return result;
    }
}
