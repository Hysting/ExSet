package com.example.network;

/**
 * Created by roro on 2015/7/1.
 */
public class StringRequest extends Request<String> {

    public StringRequest(Method method, String url, RequestListener listener) {
        super(method, url, listener);
    }

    @Override
    public String parseResponse(Response response) {
        return response.getResult();
    }


}
