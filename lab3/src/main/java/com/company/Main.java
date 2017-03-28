package com.company;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpUriRequest request = new HttpGet("http://httpbin.org/ip");
        System.out.println("Requesting: " + request.getURI());
        HttpResponse response = httpClient.execute(request);

        System.out.println("The response has URLs: " + hasURL(response));

//        response = httpClient.execute(request);
//        printResponse(response);
    }

    private static void printResponse(HttpResponse response) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static boolean hasURL(String line) {
        String urlRegex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher m = pattern.matcher(line);

        return m.matches();
    }

    private static boolean hasURL(HttpResponse response) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            if (hasURL(line)) return true;
        }

        return false;
    }
}
