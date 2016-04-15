package org.tao.test.webapp.simple.rest;

//this is the response class for StringCounter
public class StringCounterResponse {
	public enum STATUS {
		SUCCESS, FAIL
	}
	private STATUS status;
	private String data;
	
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}
