package com.example;

/**
 * Created by roro on 2015/6/30.
 */
public interface OnRequestCallback {

    void onRequestOk(NetRequestWorker worker, String data);

    void onRequestFailed(int status, String info, NetRequestWorker worker);
}
