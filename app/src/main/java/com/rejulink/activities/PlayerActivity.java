package com.rejulink.activities;

import android.content.res.Configuration;
import android.os.Bundle;

import com.rejulink.R;
import com.rejulink.utils.L;
import com.rejulink.widgets.ZSurfaceView;

/**
 * Created by danielzhang on 15/7/22.
 */
public class PlayerActivity extends BaseActivity {

    private ZSurfaceView zsurface_view_video;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        L.e("onCreate");
        zsurface_view_video = (ZSurfaceView)findViewById(R.id.zsurface_view_video);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.e("onResume");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        L.e("onConfigurationChanged" + newConfig.toString());
        zsurface_view_video.resizeSurfaceView(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
    }
}
