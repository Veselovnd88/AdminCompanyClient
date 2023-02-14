package ru.veselov.AdminCompanyClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RestManagerService {

    private final RestTemplate restTemplate;

    @Autowired
    public RestManagerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken){
        /*We need in interceptor for adding header with access token*/
        ClientHttpRequestInterceptor interceptor = new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().add("Authorization","Bearer "+accessToken);
                return execution.execute(request,body);
            }
        };
        return interceptor;
    }



}
