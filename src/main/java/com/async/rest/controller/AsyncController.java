package com.async.rest.controller;

import com.async.rest.model.CountryDTO;
import com.async.rest.service.IRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private IRepositoryService repositoryService;

    @RequestMapping("/async")
    public DeferredResult<ResponseEntity<?>> async() {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
        ListenableFuture<List<CountryDTO>> repositoryListDto = repositoryService.asyncSearch();
        repositoryListDto.addCallback(new ListenableFutureCallback<List<CountryDTO>>() {
            @Override
            public void onSuccess(List<CountryDTO> result) {
                ResponseEntity<List<CountryDTO>> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
                deferredResult.setResult(responseEntity);
                responseEntity.getBody().forEach(c -> System.out.println(c.getName()));
            }

            @Override
            public void onFailure(Throwable t) {
                log.error("Failed to fetch result from remote service", t);
                ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                deferredResult.setResult(responseEntity);
            }
        });
        return deferredResult;
    }

}
