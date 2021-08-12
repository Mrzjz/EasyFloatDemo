package com.signway.easyfloatdemo.viewpagervideo;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.signway.DigiSignage.R;


public class VideoHolder extends RecyclerView.ViewHolder {
    public StandardGSYVideoPlayer player;

    public VideoHolder(@NonNull View view) {
        super(view);
        player = view.findViewById(R.id.player);
    }
}
