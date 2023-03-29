package com.valtech.poc.sms.service;

import org.apache.http.HttpResponse;

public interface HttpService {

	HttpResponse performPostRequest(String url, String requestBody, String jwt) throws Exception;

}