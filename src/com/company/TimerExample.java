package com.company;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.TimerTask;

public class TimerExample extends TimerTask {

    private String name;

    public TimerExample(String n) {
        this.name = n;
    }

    @Override
    public void run() {
//        System.out.println("hello");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://reqres.in/api/users?page=2")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(Main::parse).join();
    }
}
