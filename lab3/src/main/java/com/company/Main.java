package com.company;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpUriRequest request = new HttpGet("http://lab3midps.96.lt/"); // http://httpbin.org/ip
        System.out.println("Requesting: " + request.getURI());
        HttpResponse response = httpClient.execute(request);

        printResponse(response);

    }

    private static void printResponse(HttpResponse response) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}

// http://bethecoder.com/applications/tutorials/tools-and-libs/commons-http-client/how-to-make-http-head-request.html