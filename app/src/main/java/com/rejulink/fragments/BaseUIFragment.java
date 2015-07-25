package com.rejulink.fragments;

import com.rejulink.utils.L;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by danielzhang on 15/7/2.
 */
public class BaseUIFragment extends BaseFragment {

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            L.e(this.getClass().getSimpleName() + " hidden");
            MobclickAgent.onPageStart(this.getClass().getSimpleName());
        } else {
            L.e(this.getClass().getSimpleName() + " show");
            MobclickAgent.onPageEnd(this.getClass().getSimpleName());
        }
    }

}
