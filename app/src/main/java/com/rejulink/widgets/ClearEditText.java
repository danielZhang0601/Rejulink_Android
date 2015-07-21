package com.rejulink.widgets;


import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.rejulink.R;


/**
 * @author sunday
 *         2013-12-04
 */
public class ClearEditText extends EditText {
    protected final static String TAG = "EditTextWithDel";
    private Drawable imgInable;
    private Context mContext;

    public ClearEditText(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    @SuppressWarnings("deprecation")
    private void init() {
        imgInable = mContext.getResources().getDrawable(R.mipmap.edit_delete);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (length() < 1) {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, imgInable, null);
                }
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View arg0, boolean isFocus) {
                if (isFocus && length() > 1) {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, imgInable, null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }

            }
        });
    }

    public void setDrawableNull() {
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgInable != null && event.getAction() == MotionEvent.ACTION_UP && isEnabled()) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            float scale = mContext.getResources().getDisplayMetrics().density;
            getGlobalVisibleRect(rect);
            rect.left = (int) (rect.right - (15 * scale + 35.5f));
            if (rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
