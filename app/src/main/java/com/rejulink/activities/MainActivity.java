package com.rejulink.activities;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rejulink.R;
import com.rejulink.fragments.CameraFragment;
import com.rejulink.fragments.EventFragment;
import com.rejulink.fragments.MoreFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    int selectedColor, normalColor;
    private TextView text_view_title_bar_text_back;
    private ImageView image_view_title_bar_text_done;

    private CameraFragment cameraFragment;
    private EventFragment eventFragment;
    private MoreFragment moreFragment;

    private LinearLayout linearLayoutCamera;
    private LinearLayout linearLayoutEvent;
    private LinearLayout linearLayoutMore;
    private ImageView imageViewCamera;
    private ImageView imageViewEvent;
    private ImageView imageViewMore;
    private TextView textViewCamera;
    private TextView textViewEvent;
    private TextView textViewMore;

    public static void launchActivity(Context context, Bundle bundle) {
        context.startActivity(new Intent(context, MainActivity.class), bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedColor = getResources().getColor(R.color.view_tab_top_line_select);
        normalColor = getResources().getColor(R.color.view_tab_top_line);

        text_view_title_bar_text_back = (TextView) findViewById(R.id.text_view_title_bar_text_back);
        //清除掉TextView的左边返回箭头
        text_view_title_bar_text_back.setCompoundDrawables(null, null, null, null);
        image_view_title_bar_text_done = (ImageView) findViewById(R.id.image_view_title_bar_text_done);
        image_view_title_bar_text_done.setImageDrawable(getResources().getDrawable(R.drawable.title_button_add));
        image_view_title_bar_text_done.setOnClickListener(this);

        linearLayoutCamera = (LinearLayout) findViewById(R.id.tab_linear_layout_1);
        linearLayoutEvent = (LinearLayout) findViewById(R.id.tab_linear_layout_2);
        linearLayoutMore = (LinearLayout) findViewById(R.id.tab_linear_layout_3);

        imageViewCamera = (ImageView) findViewById(R.id.tab_image_view_1);
        imageViewEvent = (ImageView) findViewById(R.id.tab_image_view_2);
        imageViewMore = (ImageView) findViewById(R.id.tab_image_view_3);

        textViewCamera = (TextView) findViewById(R.id.tab_text_view_1);
        textViewEvent = (TextView) findViewById(R.id.tab_text_view_2);
        textViewMore = (TextView) findViewById(R.id.tab_text_view_3);

        linearLayoutCamera.setOnClickListener(this);
        linearLayoutEvent.setOnClickListener(this);
        linearLayoutMore.setOnClickListener(this);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (savedInstanceState == null) {
            cameraFragment = new CameraFragment();
            eventFragment = new EventFragment();
            moreFragment = new MoreFragment();
            fragmentTransaction.add(R.id.frame_layout_main_fragment, cameraFragment, CameraFragment.class.getSimpleName());
            fragmentTransaction.add(R.id.frame_layout_main_fragment, eventFragment, CameraFragment.class.getSimpleName());
            fragmentTransaction.add(R.id.frame_layout_main_fragment, moreFragment, CameraFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }

        linearLayoutCamera.performClick();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.tab_linear_layout_1:
                text_view_title_bar_text_back.setText(R.string.title_bar_text_camera);
                imageViewCamera.setImageResource(R.mipmap.tab_camera_select);
                textViewCamera.setTextColor(selectedColor);
                imageViewEvent.setImageResource(R.mipmap.tab_events_normal);
                textViewEvent.setTextColor(normalColor);
                imageViewMore.setImageResource(R.mipmap.tab_more_normal);
                textViewMore.setTextColor(normalColor);
                image_view_title_bar_text_done.setVisibility(View.VISIBLE);
                fragmentTransaction.show(cameraFragment).hide(eventFragment).hide(moreFragment).commit();
                break;
            case R.id.tab_linear_layout_2:
                text_view_title_bar_text_back.setText(R.string.title_bar_text_event);
                imageViewCamera.setImageResource(R.mipmap.tab_camera_normal);
                textViewCamera.setTextColor(normalColor);
                imageViewEvent.setImageResource(R.mipmap.tab_events_select);
                textViewEvent.setTextColor(selectedColor);
                imageViewMore.setImageResource(R.mipmap.tab_more_normal);
                textViewMore.setTextColor(normalColor);
                image_view_title_bar_text_done.setVisibility(View.GONE);
                fragmentTransaction.hide(cameraFragment).show(eventFragment).hide(moreFragment).commit();
                break;
            case R.id.tab_linear_layout_3:
                text_view_title_bar_text_back.setText(R.string.title_bar_text_more);
                imageViewCamera.setImageResource(R.mipmap.tab_camera_normal);
                textViewCamera.setTextColor(normalColor);
                imageViewEvent.setImageResource(R.mipmap.tab_events_normal);
                textViewEvent.setTextColor(normalColor);
                imageViewMore.setImageResource(R.mipmap.tab_more_select);
                textViewMore.setTextColor(selectedColor);
                image_view_title_bar_text_done.setVisibility(View.GONE);
                fragmentTransaction.hide(cameraFragment).hide(eventFragment).show(moreFragment).commit();
                break;
            case R.id.image_view_title_bar_text_done:
                nextActivity = ActivityEnum.ZXING_CAPTURE_ACTIVITY;
                next();
                break;
        }
    }
}
