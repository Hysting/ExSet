package com.example.network;

/**
 * Created by roro on 2015/7/1.
 */
public class TestNet {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        Request request = new StringRequest(Request.Method.GET, "http://www.baidu.com", new Request.RequestListener() {
            @Override
            public void onComplete(Object response) {

            }

            @Override
            public void onError(int errCode, String errMsg) {

            }
        });

        queue.addRequest(request);
    }
}
