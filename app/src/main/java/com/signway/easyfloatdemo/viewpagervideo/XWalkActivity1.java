package com.signway.easyfloatdemo.viewpagervideo;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkActivityDelegate;
import org.xwalk.core.XWalkDialogManager;

public abstract class XWalkActivity1 extends FragmentActivity {

    private XWalkActivityDelegate mActivityDelegate;

    public XWalkActivity1() {
    }

    protected abstract void onXWalkReady();

    protected void onXWalkFailed() {
        this.finish();
    }

    protected XWalkDialogManager getDialogManager() {
        return this.mActivityDelegate.getDialogManager();
    }

    public boolean isXWalkReady() {
        return this.mActivityDelegate.isXWalkReady();
    }

    public boolean isSharedMode() {
        return this.mActivityDelegate.isSharedMode();
    }

    public boolean isDownloadMode() {
        return this.mActivityDelegate.isDownloadMode();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Runnable cancelCommand = new Runnable() {
            public void run() {
                XWalkActivity1.this.onXWalkFailed();
            }
        };
        Runnable completeCommand = new Runnable() {
            public void run() {
                XWalkActivity1.this.onXWalkReady();
            }
        };
        this.mActivityDelegate = new XWalkActivityDelegate(this, cancelCommand, completeCommand);
    }

    protected void onResume() {
        super.onResume();
        this.mActivityDelegate.onResume();
    }
}
