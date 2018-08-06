package com.async.rest.model;

import java.util.List;

public class RestResponse {
    List<String> messages;
    List<CountryDTO> result;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<CountryDTO> getResult() {
        return result;
    }

    public void setResult(List<CountryDTO> result) {
        this.result = result;
    }
}
