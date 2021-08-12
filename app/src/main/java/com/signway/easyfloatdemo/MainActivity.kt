package com.signway.easyfloatdemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.jd.systempal.core.SysMangerImpl
import com.signway.DigiSignage.R

/**
 * @author: zjz
 * @email: jz.zhao@signway.cn
 * @description:
 * @date :2021/5/26 16:40
 */
class MainActivity : AppCompatActivity() {
    @BindView(R.id.shutdown)
    lateinit var mShutdown : Button

    @BindView(R.id.reboot)
    lateinit var mReboot : Button

    @BindView(R.id.get_screen_bright)
    lateinit var mGetScreenBright : Button

    @BindView(R.id.ed_bright)
    lateinit var mBright : EditText

    @BindView(R.id.set_screen_bright)
    lateinit var mSetScreenBright : Button

    @BindView(R.id.set_volume)
    lateinit var mSetVolume : Button

    @BindView(R.id.ed_volume)
    lateinit var mVolume : EditText

    @BindView(R.id.get_volume)
    lateinit var mGetVolume : Button

    @BindView(R.id.timer)
    lateinit var mTimer : Button

    @BindView(R.id.remove_timer)
    lateinit var mRemoveTimer : Button

    @BindView(R.id.hide_statusbar)
    lateinit var mHideStatusBar : Button

    @BindView(R.id.show_statusbar)
    lateinit var mShowStatusBar : Button

    @BindView(R.id.trace_file)
    lateinit var mTraceFile : Button

    @BindView(R.id.screen_shot)
    lateinit var mScreenShot : Button

    @BindView(R.id.install)
    lateinit var mInstall : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initView()
    }

    fun initView() {
//        mShutdown.requestFocus()
    }

    @OnClick(R.id.shutdown, R.id.reboot, R.id.set_screen_bright, R.id.get_screen_bright, R.id.set_volume, R.id.get_volume,
    R.id.screen_shot, R.id.hide_statusbar, R.id.show_statusbar, R.id.trace_file, R.id.install, R.id.uninstall, R.id.ota_upgrade,
    R.id.recovery)
    fun click(view : View) {
        when(view.id) {
            R.id.shutdown -> {
                SysMangerImpl.getInstance().shutdown()
                Toast.makeText(this, "hhhh", Toast.LENGTH_SHORT).show()
            }

            R.id.reboot -> SysMangerImpl.getInstance().reboot()

            R.id.set_screen_bright -> {
                var brignt = mBright.text.toString().toInt()
                SysMangerImpl.getInstance().setScreenBrightness(brignt)
            }

            R.id.get_screen_bright -> Toast.makeText(this, SysMangerImpl.getInstance().screenBrightness.toString(), Toast.LENGTH_SHORT).show()

            R.id.set_volume -> {
                var volume = mVolume.text.toString().toInt()
                SysMangerImpl.getInstance().setCurrentVolume(volume)
            }

            R.id.get_volume -> Toast.makeText(this, SysMangerImpl.getInstance().currentVolume.toString(), Toast.LENGTH_SHORT).show()

            R.id.hide_statusbar -> SysMangerImpl.getInstance().hideStatusBar(false)

            R.id.show_statusbar -> SysMangerImpl.getInstance().hideStatusBar(true)

            R.id.screen_shot -> SysMangerImpl.getInstance().takeScreenshot(null)

            R.id.trace_file -> SysMangerImpl.getInstance().getTraceFile("/mnt/sdcard/trace.txt")

            R.id.install -> SysMangerImpl.getInstance().installAPK("/mnt/sdcard/Droid5186.apk","5186", null)

            R.id.uninstall -> SysMangerImpl.getInstance().uninstallAPK("com.signway.DigiSignage5186", null)

            R.id.ota_upgrade -> {
                Toast.makeText(this, "ota", Toast.LENGTH_SHORT).show()
                SysMangerImpl.getInstance().installFirmwarePackage("/mnt/sdcard")
            }

            R.id.recovery -> SysMangerImpl.getInstance().recovery()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}