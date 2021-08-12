package com.jd.systempal.core

import androidx.multidex.MultiDexApplication

class DemoApplication : MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()

       // SysMangerImpl.getInstance().init(this)
    }
}