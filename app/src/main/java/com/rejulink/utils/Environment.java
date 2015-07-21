package com.rejulink.utils;

/**
 * Created by zxd on 2015/7/20.
 */
public class Environment {
    private static boolean isTestMode = true;

    public static boolean isTestMode() {
        return isTestMode;
    }

    public static void setIsTestMode(boolean isTestMode) {
        Environment.isTestMode = isTestMode;
    }
}
