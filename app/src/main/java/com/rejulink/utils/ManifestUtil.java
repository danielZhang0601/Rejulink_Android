package com.rejulink.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by zxd on 2015/7/20.
 */
public class ManifestUtil {

    public static String getMetaData(Context context, String key, String defaultValue) {
        String value = defaultValue;
        try {
            value = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
