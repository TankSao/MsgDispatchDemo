package com.example.administrator.msgdispatchdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MsgListener{
    private MsgBroadcast broadcast;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        broadcast = new MsgBroadcast(this);
        //动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sendValue.value");
        //注册广播
        registerReceiver(broadcast, intentFilter);
        //开启服务
        Intent intent = new Intent(this, MsgService.class);
        intent.putExtra("num","10086");
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcast);
    }

    @Override
    public void onRecieveMsg(String data) {
        tv.setText(data);
    }
}
