package com.rejulink.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.rejulink.app.ActivityManager;
import com.rejulink.networks.ZAsyncHttpClient;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().pushActivity(this);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getInstance().popActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        MobclickAgent.onPause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 全部Activity
     */
    public ActivityEnum nextActivity = ActivityEnum.SPLASH_ACTIVITY;

    public void next() {
        ZAsyncHttpClient.cancel(this, true);
        switch (nextActivity) {
            case SIGN_IN_ACTIVITY:
                SignInActivity.launchActivity(this);
                break;
            case SIGN_UP_ACTIVITY:
                SignUpActivity.launchActivity(this);
                break;
            case RETRIEVE_PASSWORD_ACTIVITY:
                RetrievePasswordActivity.launchActivity(this);
                break;
            case MAIN_ACTIVITY:
                MainActivity.launchActivity(this);
                break;
            case PLAYER_ACTIVITY:
                PlayerActivity.launchActivity(this);
                break;
            case PERSON_INFO_ACTIVITY:
                PersonInfoActivity.launchActivity(this);
                break;
        }
    }
}
