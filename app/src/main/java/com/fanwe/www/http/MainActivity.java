package com.fanwe.www.http;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.lib.http.RequestManager;
import com.fanwe.lib.http.cookie.SerializableCookieStore;
import com.fanwe.lib.http.utils.LogUtils;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtils.setDebug(true);

        //设置cookie管理对象
        RequestManager.getInstance().setCookieStore(new SerializableCookieStore(this));

        //设置请求拦截对象，可用于log输出，或者一些需要全局处理的逻辑
        RequestManager.getInstance().addRequestInterceptor(new AppRequestInterceptor());

        //设置Request的唯一标识生成对象
        RequestManager.getInstance().setRequestIdentifierProvider(new AppRequestIdentifierProvider());
    }

    public void onClickAsyncRequestActivity(View view)
    {
        startActivity(new Intent(this, AsyncRequestActivity.class));
    }

    public void onClickSyncRequestActivity(View view)
    {
        startActivity(new Intent(this, SyncRequestActivity.class));
    }

    public void onClickDownloadActivity(View view)
    {
        startActivity(new Intent(this, DownloadActivity.class));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
