package com.signway.easyfloatdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;

import com.signway.DigiSignage.R;
import com.signway.easyfloatdemo.bean.JsonRootBean;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ShowActivity extends Activity implements View.OnClickListener{
    private final String TAG = ShowActivity.class.getSimpleName();

    private EditText mBrightEt;
    private Button mBrightBtn;
    private TextView mTvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mBrightEt = findViewById(R.id.et_brightness);
        mBrightBtn = findViewById(R.id.set_brightness);
        mTvTest = findViewById(R.id.tv_test);

        //mTvTest.setTextColor(getResources().getColorStateList(R.drawable.selector_touch_title_text_color));
        mTvTest.setSelected(false);

        setBrightNess();

        //hideBottomUIMenu();
        //show();

        //testBenchi();
    }




    private void setBrightNess() {
        mBrightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int b = Integer.parseInt(mBrightEt.getText().toString());
//                Settings.System.putInt(ShowActivity.this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,b);
//
//                mBrightEt.setText("");
//
//                int aa = Settings.System.getInt(ShowActivity.this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,0);
//                Log.i(TAG,"setBrightNess --- > now : " + aa);

                mTvTest.setSelected(false);
            }
        });

        mTvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvTest.setSelected(true);
            }
        });

    }





    private void show() {
//        EasyFloat.with(this)
//                // 设置浮窗xml布局文件，并可设置详细信息
//                .setLayout(R.layout.window_ploat, new OnInvokeView() {
//                    @Override
//                    public void invoke(View view) {
//                        Button setting  = view.findViewById(R.id.setting);
//                        Button goto1  = view.findViewById(R.id.goto1);
//                        Button goto9  = view.findViewById(R.id.goto9);
//
//                        setting.setOnClickListener(ShowActivity.this);
//                        goto1.setOnClickListener(ShowActivity.this);
//                        goto9.setOnClickListener(ShowActivity.this);
//                    }
//                })
//                // 设置浮窗显示类型，默认只在当前Activity显示，可选一直显示、仅前台显示
//                .setShowPattern(ShowPattern.ALL_TIME)
//                // 设置吸附方式，共15种模式，详情参考SidePattern
//                .setSidePattern(SidePattern.RESULT_HORIZONTAL)
//                // 设置浮窗的标签，用于区分多个浮窗
//                .setTag("testFloat")
//                // 设置浮窗是否可拖拽
//                .setDragEnable(true)
//                // 浮窗是否包含EditText，默认不包含
//                .hasEditText(false)
//                // 设置浮窗固定坐标，ps：设置固定坐标，Gravity属性和offset属性将无效
//                .setLocation(100, 200)
//                // 设置拖拽边界值
//                .setBorder(100, 100,800,800).show();

        // 创建浮窗（这是关键哦😂
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                Toast.makeText(ShowActivity.this,"设置", Toast.LENGTH_SHORT).show();
                runCmd("input keyevent 142");
                //runCmd("reboot");
                break;
            case R.id.goto1:
                Toast.makeText(ShowActivity.this,"goto1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.goto9:
                Toast.makeText(ShowActivity.this,"goto9", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    public void runCmd(String cmd) {
        Log.i(TAG, "start  reboot");
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            Log.i(TAG, "reboot fail msg = " + e.toString());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Log.i(TAG, "onKeyDown --- > keyCode : " + keyCode);
        if (keyCode == 142) {
            Log.i(TAG,"onKeyDown --- > 接收到信息");
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    public void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }


    private void sendInfo() {
        Intent intent = new Intent("com.signway.START_SIGNWAY_APP");
        //intent.setComponent(new ComponentName("com.signway.easyfloatdemo","com.signway.easyfloatdemo.MyReceiver"));
        intent.setComponent(new ComponentName("com.signway.DigiSignage8581","com.signway.broadcast.BootCompletedReceiver"));
        //sendStickyBroadcast(intent);

        sendBroadcast(intent,null);

//        Intent intent1 = new Intent("com.signway.test");
//        //intent1.setComponent(new ComponentName("com.signway.easyfloatdemo","com.signway.easyfloatdemo.MyReceiver"));
//        intent1.setComponent(new ComponentName(this,MyReceiver1.class));
//        sendBroadcast(intent1,null);
    }

    private void rigister() {
        MyReceiver lowReceiver = new MyReceiver();
        IntentFilter lowIntent = new IntentFilter("com.signway.test");

        lowIntent.setPriority(10);
        this.registerReceiver(lowReceiver,lowIntent);

        MyReceiver1 orderReceiver = new MyReceiver1();
        IntentFilter orderIntent = new IntentFilter("com.signway.test");
        orderIntent.setPriority(100);
        this.registerReceiver(orderReceiver,orderIntent);

    }








    private void testBenchi() {
        Log.i(TAG,"testBenchi --- > start");
//        String upgradeStr = FileUtil.readFile("/mnt/sdcard/bcdata.js");
        try {
            String upgradeStr = FileUtils.readFileToString(new File("/mnt/sdcard/bcdata.js"));
            Log.i(TAG,"testBenchi --- > upgradeStr : " + upgradeStr);
            JsonRootBean jsonDataBean = JSON.parseObject(upgradeStr, JsonRootBean.class);
            if (jsonDataBean == null) {
                Log.i(TAG,"testBenchi --- > jsonDataBean == null ");
                return;
            }

            Log.i(TAG,"testBenchi --- > end");


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}