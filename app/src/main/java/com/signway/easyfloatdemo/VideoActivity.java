package com.signway.easyfloatdemo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.signway.DigiSignage.R;

import java.io.IOException;

public class VideoActivity extends Activity {
    private final String TAG = VideoActivity.class.getSimpleName();
    private VideoView surfaceView;
    private MediaController player;
    private SurfaceHolder holder;
    private Button mSeekFast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        surfaceView = (VideoView) findViewById(R.id.surfaceView);

        mSeekFast = findViewById(R.id.seek_fast);
        mSeekFast.requestFocus();
        mSeekFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VideoActivity.this,"快进",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"------------ 快进");
                retryHandler.sendEmptyMessage(1);
            }
        });

        initPlayer();
    }

    private void initPlayer() {
        player = new MediaController(this);
        surfaceView.setVideoPath("/mnt/sdcard/zekDyASH_2762825851_shd.mp4");
        player.setMediaPlayer(surfaceView);
        surfaceView.setMediaController(player);
        surfaceView.start();

    }

    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    private Handler retryHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            int mediaDuration = surfaceView.getCurrentPosition();
            Log.i(TAG,"retryHandler --- > mediaDuration : " + mediaDuration);
            surfaceView.seekTo(mediaDuration + 4000);

            retryHandler.sendEmptyMessageDelayed(1,2 * 1000);
        }
    };
}