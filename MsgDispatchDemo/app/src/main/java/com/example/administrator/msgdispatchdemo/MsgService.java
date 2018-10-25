package com.example.administrator.msgdispatchdemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/10/25.
 */

public class MsgService  extends IntentService {
    public MsgService() {
        super("");

    }
    public MsgService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        final String num = intent.getStringExtra("num");//接收建立长连接所需的参数
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                //可建立长连接，这里模拟实现
                Intent intent1 = new Intent("com.sendValue.value");
                intent1.putExtra("value",num+"返回");
                sendBroadcast(intent1);
            }
        };
        t.start();
    }
}
