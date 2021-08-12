package com.signway.easyfloatdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.signway.DigiSignage.R;

import java.io.IOException;

public class PlayActivity extends Activity {
    private final String TAG = PlayActivity.class.getSimpleName();
    private SurfaceView surfaceView;
    private MediaPlayer player;
    private SurfaceHolder holder;
    private Button mSeekFast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        mSeekFast = findViewById(R.id.seek_fast);
        mSeekFast.requestFocus();
        mSeekFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayActivity.this,"快进",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"------------ 快进");
                retryHandler.sendEmptyMessage(1);
            }
        });

        initPlayer();
    }

    private void initPlayer() {
        player=new MediaPlayer();
        try {
            player.setDataSource("/mnt/sdcard/zekDyASH_2762825851_shd.mp4");

            holder=surfaceView.getHolder();
            holder.addCallback(new MyCallBack());
            player.prepare();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    player.start();
                    player.setLooping(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Log.i(TAG,"onSeekComplete --- > CurrentPosition : " + mediaPlayer.getCurrentPosition()
                + " -- Duration : " + mediaPlayer.getDuration());
            }
        });
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            player.setDisplay(holder);
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
            int mediaDuration = player.getCurrentPosition();
            Log.i(TAG,"retryHandler --- > mediaDuration : " + mediaDuration);
            player.seekTo(mediaDuration + 4000);

            retryHandler.sendEmptyMessageDelayed(1,4 * 1000);
        }
    };
}