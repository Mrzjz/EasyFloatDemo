package com.signway.easyfloatdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.signway.DigiSignage.R;
import com.signway.easyfloatdemo.bean.JsonRootBean;
import com.signway.easyfloatdemo.viewpagervideo.DataBean;
import com.signway.easyfloatdemo.viewpagervideo.MultipleTypesAdapter;
import com.signway.easyfloatdemo.viewpagervideo.NumIndicator;
import com.signway.easyfloatdemo.viewpagervideo.VideoHolder;
import com.signway.easyfloatdemo.viewpagervideo.XWalkActivity1;
import com.wang.avi.AVLoadingIndicatorView;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.listener.OnPageChangeListener;

import org.apache.commons.io.FileUtils;
import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewpagerVideoActivity extends XWalkActivity1 {
    private final String TAG = ViewpagerVideoActivity.class.getSimpleName();

//    @BindView(R.id.banner)
//    Banner banner;
    StandardGSYVideoPlayer player;
    @BindView(R.id.loading_view)
    AVLoadingIndicatorView mLoadingView;

    @BindView(R.id.screen_shot)
    Button mScreenShot;
    @BindView(R.id.img)
    ImageView mImg;

    @BindView(R.id.webview)
    WebView mWeb;

    @BindView(R.id.xwalkview)
    XWalkView xwalkview;

    @Override
    protected void onXWalkReady() {
//        XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);   //开启默认动画
//        XWalkSettings setting = xwalkview.getSettings();
//
//        setting.setLoadWithOverviewMode(false);
//
//        setting.setJavaScriptEnabled(true);
//
//        setting.setJavaScriptCanOpenWindowsAutomatically(true);
//
//        setting.setUseWideViewPort(true);
//
//        setting.setLoadWithOverviewMode(true);
//
//        setting.setLoadsImagesAutomatically(true);
//
//        setting.setSupportMultipleWindows(true);
//
//       setting.setSupportZoom(true);                     //支持多窗口
//
//        setting.setAllowFileAccess(true);
//
//        setting.setDomStorageEnabled(true);
//
//        setting.setAllowContentAccess(true);
//
//        xwalkview.requestFocus();
//
//        setting.setCacheMode( WebSettings.LOAD_NO_CACHE);

//        xwalkview.setResourceClient(object : XWalkResourceClient(xwalkview) {
//            override fun onLoadStarted(view: XWalkView?, url: String?) {
//                super.onLoadStarted(view, url)
//            }
//
//            override fun onLoadFinished(view: XWalkView?, url: String?) {
//                super.onLoadFinished(view, url)
//            }
//
//            override fun shouldOverrideUrlLoading(view: XWalkView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//
//            override fun onReceivedSslError(view: XWalkView?, callback:
//            ValueCallback<Boolean>?, error: SslError?) {
//                callback?.onReceiveValue(true)
//                super.onReceivedSslError(view, callback, error)
//            }
//
//
//            override fun onReceivedLoadError(view: XWalkView?, errorCode: Int,
//                    description: String?, failingUrl: String?) {
//                super.onReceivedLoadError(view, errorCode, description, failingUrl)
//            }
//
//            override fun onProgressChanged(view: XWalkView?, process: Int) {
//                super.onProgressChanged(view, process)
//                if (...) {
//                    ...
//                    progressBar.setProgress(process)
//                    ...
//                } else {
//                    ...
//                }
//            }
//        })
//        xwalkview.setUIClient(object :XWalkUIClient(xwalkview){
//
//            override fun onJsAlert(view: XWalkView?, url: String?,
//                    message: String?, result: XWalkJavascriptResult?): Boolean {
//                return super.onJsAlert(view, url, message, result)
//            }
//
//            override fun onReceivedTitle(view: XWalkView?, title: String?) {
//                super.onReceivedTitle(view, title)
//            }
//
//            override fun openFileChooser(view: XWalkView?, uploadFile:ValueCallback<Uri>?, acceptType: String?, capture: String?) {
//                super.openFileChooser(view, uploadFile, acceptType, capture)
//            }
//        })


//
//        xwalkview.setResourceClient(new XWalkResourceClient(xwalkview));
//        xwalkview.setUIClient(new XWalkUIClient(xwalkview));


        Log.i(TAG,"xwalkview.loadUrl(\"www.baidu.com\")  ------------- 1");

        xwalkview.loadUrl("file://mnt/sdcard/bctest/772/ab2823cc07051b1da6ed4a603dab1cc4.html?sn=4A90BFD4&ndCode=SCQB10");
        //xwalkview.loadUrl("http://www.baidu.com/");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_video);
        ButterKnife.bind(this);


        //设置允许访问浏览器页面的js方法
        XWalkPreferences.setValue("enable-javascript", true);
        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        Log.i(TAG,"xwalkview.loadUrl(\"www.baidu.com\") ------------- 2");

        mWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        mWeb.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        mWeb.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        mWeb.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        mWeb.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        mWeb.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        mWeb.getSettings().setAppCacheEnabled(true);//是否使用缓存
        mWeb.getSettings().setDomStorageEnabled(true);//DOM Storage



       mWeb.loadUrl("file://mnt/sdcard/bctest/772/ab2823cc07051b1da6ed4a603dab1cc4.html?sn=4A90BFD4&ndCode=SCQB10");

        //mWeb.loadUrl("http://www.baidu.com/");
        //mWeb.loadUrl("http://dsmp-dev.mercedes-benz.com.cn/cdmsA/data/touchMenu/128/e33ff0cb5f22986f81ba6c37f0bdf005.html?ndCode=ESHL30&samsungPad=1");
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });




//
//        xwalkview.loadUrl("https://liulanmi.com/labs/core.html");
//        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
//        xwalkview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //使用WebView加载显示url
//                view.loadUrl(url);
//                //返回true
//                return true;
//            }
//        });




//        mLoadingView.show();
//
//        mScreenShot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startScreenShot();
//            }
//        });

//
//        banner.addBannerLifecycleObserver(this)
//                .setAdapter(new MultipleTypesAdapter(this, DataBean.getTestDataVideo()))
//                .setIndicator(new NumIndicator(this))
//                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
//                .addOnPageChangeListener(new OnPageChangeListener() {
//                    @Override
//                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                        stopVideo(position);
//                    }
//
//                    @Override
//                    public void onPageSelected(int position) {
//                        Log.e("--","position:"+position);
//                        stopVideo(position);
//                    }
//
//                    @Override
//                    public void onPageScrollStateChanged(int state) {
//
//                    }
//                });
    }

    private void stopVideo(int position) {
//        if (player == null) {
//            RecyclerView.ViewHolder viewHolder = banner.getAdapter().getViewHolder();
//            if (viewHolder instanceof VideoHolder) {
//                VideoHolder holder = (VideoHolder) viewHolder;
//                player = holder.player;
//                if (position != 0) {
//                    player.onVideoPause();
//                }
//            }
//        }else {
//            if (position != 0) {
//                player.onVideoPause();
//            }
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null)
            player.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();




        if (player != null)
            player.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // GSYVideoManager.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        //释放所有
        if (player != null)
            player.setVideoAllCallBack(null);
        super.onBackPressed();
    }




    private void startScreenShot() {
        String path = "/storage/emulated/0/Qmedia/screenShot/screenShot20210713130211714.png";
        Intent intent = new Intent();
        intent.setAction("com.qmedia.adapter.receiver.screen_capture");
        intent.putExtra("screenPath", path);
        intent.putExtra("commandID","111");
        this.sendBroadcast(intent);

        try {
            FileInputStream is = new FileInputStream(path);
            Bitmap bmp = BitmapFactory.decodeStream(is);

            mImg.setImageBitmap(bmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}