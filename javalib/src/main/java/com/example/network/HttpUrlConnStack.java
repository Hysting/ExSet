package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by roro on 2015/7/1.
 */
public class HttpUrlConnStack implements HttpStack {
    @Override
    public Response performRequest(Request<?> request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str;
            StringBuilder sb = new StringBuilder();
            while((str = br.readLine())!= null){
                sb.append(str);
            }
            Response response = new Response();
            response.setResult(sb.toString());

            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
