package com.rejulink.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

/**
 * Created by danielzhang on 15/7/1.
 */
public class ShowMessage {
    public static void showMessage(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showMessage(Context context, CharSequence resStr) {
        Toast.makeText(context, resStr, Toast.LENGTH_SHORT).show();
    }

    public static void showMessageWithCode(Context context, int code) {
        int toastText;
        if (context == null) {
            return;
        }
        Resources resource = context.getResources();
        String pkgName = context.getPackageName();
        try {
            toastText = resource.getIdentifier("define_code_" + code,
                    "string", pkgName);
        } catch (Exception e) {
            toastText = -1;
        }
        if (toastText <= 0) {
            toastText = resource.getIdentifier("define_code_1", "string", pkgName);
        }
        showMessage(context, toastText);
    }
}
