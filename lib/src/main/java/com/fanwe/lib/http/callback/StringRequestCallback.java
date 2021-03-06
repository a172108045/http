package com.fanwe.lib.http.callback;

/**
 * Created by zhengjun on 2017/10/23.
 */
public abstract class StringRequestCallback extends RequestCallback
{
    private String mResult;

    @Override
    public void onSuccessBackground() throws Exception
    {
        super.onSuccessBackground();
        mResult = getResponse().getBody();
    }

    public String getResult()
    {
        return mResult;
    }
}
