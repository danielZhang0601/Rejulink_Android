package com.rejulink.fragments;


import android.app.Fragment;

import com.rejulink.utils.L;
import com.umeng.analytics.MobclickAgent;

public class BaseFragment extends Fragment {

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            L.e(this.getClass().getSimpleName() + " hidden");
            MobclickAgent.onPageStart(this.getClass().getSimpleName());
        }else{
            L.e(this.getClass().getSimpleName()+" show");
            MobclickAgent.onPageEnd(this.getClass().getSimpleName());
        }
    }
}
