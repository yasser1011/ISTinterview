package com.company;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws IOException {
        TimerExample te1=new TimerExample("Task1");

        Timer t=new Timer();
        t.scheduleAtFixedRate(te1, 0,5*1000);

    }

    public static String parse(String responseBody){
        List<String> emails = new ArrayList<>();
        JSONObject response = new JSONObject(responseBody);
        JSONArray data = new JSONArray(response.getJSONArray("data"));

        for (int i = 0; i < data.length(); i++){
            JSONObject dataObject = data.getJSONObject(i);
            String email = dataObject.getString("email");
            emails.add(email);

        }
        System.out.println(emails);
        return "";
    }
}
