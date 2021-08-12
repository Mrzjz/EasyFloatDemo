package com.signway.easyfloatdemo.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by admin on 2019/4/16.
 */
public class PingUtils {
    private static final String TAG = "PingUtils1";
    public static String host = ".itls.cn-shanghai.aliyuncs.com";
    //public static String host = "139.196.135.153";

    /**
     * execPing
     */
    public static void execPing(final String host, final PingListener listener) {
        //BigScreenMainDisp.getInstance().displayDomainStatus(R.string.start_ping);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                pingHost(host, listener);
            }
        });
    }


    /**
     * execPing
     */
    private static void pingHost(String host) {
        String line = null;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + host +" -w 3000");
            BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**
     * execPing
     */
    private static void pingHost(String host, PingListener listener) {
        // 获取当前程序的运行进对象
        Runtime runtime = Runtime.getRuntime();
        //声明处理类对象
        Process process = null;
        //返回行信息
        String line = null;
        //输入流
        InputStream is = null;
        // 字节流
        InputStreamReader isr = null;
        BufferedReader br = null;
        // 结果
        boolean res = false;
        try {
            // PING
            process =runtime.exec("ping " + host);
            // 实例化输入流
            is =process.getInputStream();
            // 把输入流转换成字节流
            isr = new InputStreamReader(is);
            // 从字节中读取文本
            br = new BufferedReader(isr);
            Log.e(TAG, "line :" + br.readLine());
            while ((line= br.readLine()) != null) {
                Log.e(TAG, "while line:" + line);
                if( line.toLowerCase().contains("TTL".toLowerCase())) {
                    res= true;
                    break;
                }
            }
            if (res){
                Log.e(TAG, "ping：" + host + " ---> CONNECT");
                listener.ping(true);
            } else{
                Log.e(TAG, "ping：" + host + " ---> DISCONNECT");
                listener.ping(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null){
                    is.close();
                }
                if (isr != null){
                    isr.close();
                }
                if (br != null){
                    br.close();
                }
                if (process != null){
                    process.destroy();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * PING
     */
    public interface PingListener{
        /*PING RES*/
        void ping(boolean res);
    }

}
