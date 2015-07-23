package com.rejulink.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.FrameLayout;

/**
 * Created by zxd on 2015/7/22.
 */
public class ZSurfaceView extends SurfaceView {

    private Context context;
    private boolean isLandscape;

    public ZSurfaceView(Context context) {
        super(context);
        this.context = context;
    }

    public ZSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public ZSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void resizeSurfaceView(boolean isLandscape, int screenWidth, int screenHeight) {
        int newWidth, newHeight;
        this.isLandscape = isLandscape;
        if (isLandscape) {
            newWidth = screenHeight * 16 / 9;
            newHeight = screenHeight;
        } else {
            newWidth = screenWidth;
            newHeight = screenWidth * 9 / 16;
        }
        setLayoutParams(new FrameLayout.LayoutParams(newWidth, newHeight));
    }
}
