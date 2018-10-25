package com.example.administrator.msgdispatchdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2018/10/25.
 */

public class MsgBroadcast  extends BroadcastReceiver {
    private MsgListener listener;
    public MsgBroadcast(MsgListener listener){
        this.listener = listener;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("value");
        if(listener!=null){
            listener.onRecieveMsg(data);
        }
    }
}
