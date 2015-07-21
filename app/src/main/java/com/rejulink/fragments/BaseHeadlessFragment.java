package com.rejulink.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by danielzhang on 15/7/2.
 */
public class BaseHeadlessFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
