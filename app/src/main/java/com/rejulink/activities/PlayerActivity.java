package com.rejulink.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.rejulink.R;
import com.rejulink.utils.L;
import com.rejulink.widgets.ZSurfaceView;

/**
 * Created by danielzhang on 15/7/22.
 */
public class PlayerActivity extends BaseActivity {

    private ZSurfaceView zsurface_view_video;
    private DisplayMetrics displayMetrics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        L.e("onCreate");
        zsurface_view_video = (ZSurfaceView) findViewById(R.id.zsurface_view_video);
        displayMetrics = getResources().getDisplayMetrics();
        zsurface_view_video.resizeSurfaceView(false, displayMetrics.widthPixels, displayMetrics.heightPixels);
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
        zsurface_view_video.resizeSurfaceView(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE, displayMetrics.widthPixels, displayMetrics.heightPixels);
        setDisplayType(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    private void setDisplayType(boolean isFullScreen) {
        int uiOpts;
        if (isFullScreen) {
            uiOpts = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
        } else {
            uiOpts = View.SYSTEM_UI_FLAG_VISIBLE;
        }
        getWindow().getDecorView().setSystemUiVisibility(uiOpts);
    }

}
