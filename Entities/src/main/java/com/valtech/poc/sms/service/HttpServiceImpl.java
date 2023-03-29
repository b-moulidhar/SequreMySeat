package com.valtech.poc.sms.service;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;


@Service
public class HttpServiceImpl implements HttpService {
	
	@Override
	public HttpResponse performPostRequest(String url, String requestBody, String jwt) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        // add Authorization header with JWT token
        httpPost.setHeader("Authorization", "Bearer " + jwt);
        // execute the request and return the response
        HttpResponse response = httpClient.execute(httpPost);
        return response;
    }

}
