package com.signway.easyfloatdemo.net;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.signway.DigiSignage.R;
import com.signway.easyfloatdemo.MyReceiver;
import com.signway.easyfloatdemo.MyReceiver1;

public class NetActivity extends AppCompatActivity implements Handler.Callback{
    private final String TAG = NetActivity.class.getSimpleName();
    private NetSpeedTimer mNetSpeedTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        Handler handler = new Handler(this);
        //创建NetSpeedTimer实例
        mNetSpeedTimer = new NetSpeedTimer(this, new NetSpeed(), handler).setDelayTime(1000).setPeriodTime(2000);
        //在想要开始执行的地方调用该段代码
        mNetSpeedTimer.startSpeedTimer();

    }

    @Override
    public boolean handleMessage(Message msg) {
        // TODO Auto-generated method stub
        switch (msg.what) {
            case NetSpeedTimer.NET_SPEED_TIMER_DEFAULT:
                String speed = (String)msg.obj;
                //打印你所需要的网速值，单位默认为kb/s
                Log.i(TAG, "current net speed  = " + speed);

                PingUtils.execPing("192.168.40.110", new PingUtils.PingListener() {
                    @Override
                    public void ping(boolean res) {
                        Log.i(TAG,"execPing --- > res :" + res);
                    }
                });

                break;

            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        if(null != mNetSpeedTimer){
            mNetSpeedTimer.stopSpeedTimer();
        }
        super.onDestroy();
    }


}