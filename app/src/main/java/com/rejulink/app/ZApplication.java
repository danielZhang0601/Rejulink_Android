package com.rejulink.app;

import android.app.Application;
import android.content.Context;

import com.rejulink.utils.Environment;
import com.rejulink.utils.GlobalDefine;
import com.rejulink.utils.ManifestUtil;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

public class ZApplication extends Application {

    private static Context _context;
    private static ZApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        AnalyticsConfig.enableEncrypt(true);
        //测试环境不上传统计数据
        if (GlobalDefine.EnvironmentTest.equals(ManifestUtil.getMetaData(this, GlobalDefine.UmengChannel, GlobalDefine.EnvironmentTest))){
            Environment.setIsTestMode(true);
        }
        else{   //非测试环境上传数据
            Environment.setIsTestMode(false);
            MobclickAgent.updateOnlineConfig(_context);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public static Context get_context() {
        return _context;
    }

    public synchronized static ZApplication getInstance() {
        if (null == instance) {
            instance = new ZApplication();
        }
        return instance;
    }
}
