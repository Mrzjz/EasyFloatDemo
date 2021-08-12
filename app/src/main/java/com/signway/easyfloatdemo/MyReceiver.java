package com.signway.easyfloatdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author: zjz
 * @email: jz.zhao@signway.cn
 * @description:
 * @date :2021/5/14 15:05
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MainActivity"," ---------- 收到广播   0");
    }
}
