package com.rejulink.activities;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.TextHttpResponseHandler;
import com.rejulink.R;
import com.rejulink.networks.ZAsyncHttpClient;
import com.rejulink.protocols.CMServerAccountProtocol;
import com.rejulink.protocols.bean.ResponseCMSNormal;
import com.rejulink.utils.CodeDefine;
import com.rejulink.utils.GlobalDefine;
import com.rejulink.utils.L;
import com.rejulink.utils.SharedPreferenceHelper;

import org.apache.http.Header;

@SuppressWarnings("deprecation")
public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView_splash_root = (ImageView) findViewById(R.id.imageView_splash_root);
        AlphaAnimation alpha = new AlphaAnimation(0.5f, 1.0f);
        alpha.setDuration(2000);
        alpha.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
                connectToServer();
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                next();
                finish();
            }
        });
        imageView_splash_root.startAnimation(alpha);
        nextActivity = ActivityEnum.SIGN_IN_ACTIVITY;
    }

    private void connectToServer() {
        CMServerAccountProtocol.test(this, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                L.d("connectToServer Success");
                addCookie();
                autoLogin();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            }
        });
    }

    private void autoLogin() {
        String account = (String) SharedPreferenceHelper.get(this, GlobalDefine.SavedAccount, "");
        String password = (String) SharedPreferenceHelper.get(this, GlobalDefine.SavedPassword, "");

        if (!account.isEmpty() && !password.isEmpty())
            CMServerAccountProtocol.login(this, account, password, "123456", new TextHttpResponseHandler() {
                @Override
                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                }

                @Override
                public void onSuccess(int i, Header[] headers, String s) {
                    ResponseCMSNormal res = JSON.parseObject(s, ResponseCMSNormal.class);
                    if (res.getCode() == CodeDefine.SUCCESS_DONE)
                        nextActivity = ActivityEnum.MAIN_ACTIVITY;
                }
            });
    }

    private void addCookie() {
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        ZAsyncHttpClient.setCookieStore(myCookieStore);
    }
}
