package com.example.network;

/**
 * Created by roro on 2015/7/1.
 */
public interface HttpStack {
    public Response performRequest(Request<?> request);
}
