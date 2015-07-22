package com.rejulink.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.rejulink.R;

/**
 * Created by danielzhang on 15/7/22.
 */
public class PlayerActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_player);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
