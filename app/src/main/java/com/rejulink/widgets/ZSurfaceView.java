package com.rejulink.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.rejulink.utils.L;

/**
 * Created by zxd on 2015/7/22.
 */
public class ZSurfaceView extends SurfaceView {

    private int viewWidth,viewHeight;

    public ZSurfaceView(Context context) {
        super(context);
    }

    public ZSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        viewWidth = right - left;
        viewHeight = bottom - top;
        L.e("viewWidth:"+viewWidth+" viewHeight:"+viewHeight);
    }

    public void resizeSurfaceView(boolean isLandscape){
        int newWidth , newHeight;
        if (isLandscape){
            newHeight = viewHeight;
            newWidth = viewHeight * 16 / 9;
        }else{
            newWidth = viewWidth;
            newHeight = viewWidth * 9 / 16;
        }
        setLayoutParams(new FrameLayout.LayoutParams(newWidth,newHeight));
    }
}
