/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.yandex.translate;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author artur
 */
public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("translate.yandex.net").setPath("/api/v1.5/tr/translate")
                .setParameter("key", "0")
                .setParameter("lang", "20")
                .setParameter("text", "20");
        URI uri = builder.build();
        System.out.println(uri.toString());
        HttpGet httpget = new HttpGet(uri);

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = null;
            try {
                instream = entity.getContent();
                String responseAsString = IOUtils.toString(instream);
                parseAndDownload(responseAsString);
            } finally {
                if (instream != null)
                    instream.close();
            }

        }
    }
    
    private static void parseAndDownload(String resp) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(resp);
        JSONArray mp3list = (JSONArray) jsonResponse.get("response");
        for (int i=1; i<mp3list.size(); i++) {
            JSONObject mp3 = (JSONObject) mp3list.get(i);

            // папка должна существовать
            String pathname = "e:/music/" + fixWndowsFileName(mp3.get("artist") +
                    " - " + mp3.get("title"));
            try {
                File destination = new File(pathname + ".mp3");
                if (!destination.exists()) {
                    FileUtils.copyURLToFile(new URL((String) mp3.get("url")), destination);
                }
            } catch (FileNotFoundException e) {
                System.out.print("ERROR "+pathname);
            }
        }
    }

    private static String fixWndowsFileName(String pathname) {
        String[] forbiddenSymbols = new String[] {"<", ">", ":", "\"", "/", "\\", "|", "?", "*"};
        String result = pathname;
        for (String forbiddenSymbol: forbiddenSymbols) {
            result = StringUtils.replace(result, forbiddenSymbol, "");
        }
        return StringEscapeUtils.unescapeXml(result);
    }
}
