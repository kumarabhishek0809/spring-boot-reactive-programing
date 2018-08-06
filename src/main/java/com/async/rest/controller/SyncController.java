package com.async.rest.controller;

import com.async.rest.model.CountryDTO;
import com.async.rest.service.IRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SyncController {

    private static final Logger log = LoggerFactory.getLogger(SyncController.class);

    @Autowired
    private IRepositoryService repositoryService;

    @RequestMapping("/sync")
    public List<CountryDTO> sync() {
        List<CountryDTO> countryDTOS = repositoryService.syncSearch();
        System.out.println(countryDTOS);
        return countryDTOS;
    }

}
