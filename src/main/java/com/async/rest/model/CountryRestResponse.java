package com.async.rest.model;

import java.util.List;

public class CountryRestResponse {

	/*
	 * { "RestResponse" : { "messages" : [ "Total [249] records found." ], "result"
	 * : [ {}]
	 */

	private String messages;
	private List<CountryDTO> result;

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public List<CountryDTO> getResult() {
		return result;
	}

	public void setResult(List<CountryDTO> result) {
		this.result = result;
	}

}
