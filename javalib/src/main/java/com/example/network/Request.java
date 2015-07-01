package com.example.network;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roro on 2015/7/1.
 */
public abstract class Request<T> implements Comparable<Request<T>>{


    @Override
    public int compareTo(Request<T> o) {
        return 0;
    }

    /**
     * http请求方法枚举,这里我们只有GET, POST, PUT, DELETE四种
     */
    public enum Method {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");

        private final String mHttpMethod;

        Method(String method) {
            this.mHttpMethod = method;
        }

        @Override
        public String toString() {
            return "Method{" +
                    "mHttpMethod='" + mHttpMethod + '\'' +
                    '}';
        }
    }

    /**
     * 优先级枚举
     */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE;
    }

    public void setSerialNum(int serialNum) {
        this.mSerialNum = serialNum;
    }

    /**
     * 请求序列号
     */
    protected int mSerialNum = 0;

    /**
     * 默认优先级
     */
    protected Priority mPriority = Priority.NORMAL;

    /**是否取消请求*/
    protected boolean isCancel = false;

    /**是否缓存*/
    protected boolean mShouldCache = false;

    public String getUrl() {
        return mUrl;
    }

    /**请求地址*/
    private String mUrl = "";

    /**默认请求方法*/
    protected Method mRequestMethod = Method.GET;

    /**请求头部*/
    private Map<String,String> mHeaders = new HashMap<>();

    /**请求参数*/
    private Map<String,String> mRequestParams = new HashMap<>();

    /**请求Listener*/
    private final RequestListener mRequestListener;

    public Request(Method method, String url, RequestListener listener) {
        mRequestMethod = method;
        mUrl = url;
        this.mRequestListener = listener;
    }

    public interface RequestListener<T>{
        void onComplete(T response);
        void onError(int errCode,String errMsg);
    }

    public abstract T parseResponse(Response response);

    public final void deliveryResponse(Response response){
        T result = parseResponse(response);
        if (mRequestListener != null){
            mRequestListener.onComplete(result);
        }
    }
}
