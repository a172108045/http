package com.fanwe.www.http;

import android.util.Log;

import com.fanwe.lib.http.Request;
import com.fanwe.lib.http.Response;
import com.fanwe.lib.http.interceptor.RequestInterceptor;

/**
 * http请求拦截
 */
public class AppRequestInterceptor implements RequestInterceptor
{
    public static final String TAG = "AppRequestInterceptor";

    @Override
    public void beforeExecute(Request request)
    {
        //请求发起之前回调
        Log.i(TAG, "beforeExecute:" + request);
    }

    @Override
    public void afterExecute(Response response)
    {
        //请求发起之后回调
        Log.i(TAG, "afterExecute:" + response.getRequest());
    }
}
