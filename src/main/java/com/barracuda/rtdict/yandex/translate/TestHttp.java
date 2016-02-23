/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.yandex.translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author artur
 */
public class TestHttp {

    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://www.vogella.com");
        HttpResponse response = client.execute(request);

// Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            //textView.append(line);
        }
    }
}
