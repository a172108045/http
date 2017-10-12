package com.fanwe.lib.http;

import com.fanwe.lib.http.callback.IRequestCallback;
import com.fanwe.lib.task.SDTask;

/**
 * Created by zhengjun on 2017/10/11.
 */
class RequestTask extends SDTask
{
    private Request mRequest;
    private IRequestCallback mCallback;

    public RequestTask(Request request, IRequestCallback callback)
    {
        mRequest = request;
        if (callback == null)
        {
            callback = IRequestCallback.EMPTY_CALLBACK;
        }
        mCallback = callback;
    }

    public Request getRequest()
    {
        return mRequest;
    }

    public IRequestCallback getCallback()
    {
        return mCallback;
    }

    @Override
    protected void onSubmit()
    {
        super.onSubmit();
        getCallback().onStart();
    }

    @Override
    protected void onRun() throws Exception
    {
        Response response = getRequest().execute();

        getCallback().setResponse(response);
        getCallback().onSuccessBackground();
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                getCallback().onSuccess();
                getCallback().onFinish();
            }
        });
    }

    @Override
    protected void onError(final Exception e)
    {
        super.onError(e);
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                getCallback().onError(e);
                getCallback().onFinish();
            }
        });
    }

    @Override
    protected void onCancel()
    {
        super.onCancel();
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                getCallback().onCancel();
                getCallback().onFinish();
            }
        });
    }
}
